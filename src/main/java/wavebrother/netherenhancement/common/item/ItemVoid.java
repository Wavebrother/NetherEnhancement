package wavebrother.netherenhancement.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.network.NetworkHooks;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.client.gui.CheckboxButton;
import wavebrother.netherenhancement.common.blocks.QuartzPedestal;
import wavebrother.netherenhancement.common.containers.InventoryFilterContainer;
import wavebrother.netherenhancement.common.init.ModBlocks;
import wavebrother.netherenhancement.common.util.FilterInfo;
import wavebrother.netherenhancement.common.util.FilterInfoImpl;
import wavebrother.netherenhancement.common.util.IItemFilter;
import wavebrother.netherenhancement.common.util.ItemFiltersAPI;
import wavebrother.netherenhancement.common.util.QuartzTier;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class ItemVoid extends Item implements IQuartzItem, IItemFilter {

	public static final String voidTag = "itemVoid";
	public static final String voidChild = "itemVoidChild";
	public static final String voidIndex = "itemVoidIndex";
	public final QuartzTier tier;

	public final CheckboxButton autoDelete = new CheckboxButton(1, 1, 18, 18, "Void", false);

	public ItemVoid(QuartzTier tier, String name) {
		super(new Item.Properties().maxStackSize(1).group(NetherEnhancement.CREATIVE_TAB));
		setRegistryName(name);
		this.tier = tier;
	}

	@Override
	public QuartzTier getQuartzTier() {
		return tier;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack item = playerIn.getHeldItem(handIn);
		if (playerIn.isSneaking()) {

			CompoundNBT NBT = item.getOrCreateTag();
			NBT.putBoolean(voidTag, !NBT.getBoolean(voidTag));
			if (NBT.getBoolean(voidTag)) {
				playerIn.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, 1);
			} else {
				playerIn.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, -1);
			}
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
		} else {
			if (!worldIn.isRemote) {
				NetworkHooks.openGui((ServerPlayerEntity) playerIn, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return item.getDisplayName();
					}

					@Override
					public InventoryFilterContainer createMenu(int id, PlayerInventory playerInventory,
							PlayerEntity player) {
						return new InventoryFilterContainer(id, playerInventory, handIn, tier);
					}
				}, buffer -> buffer.writeBoolean(handIn == Hand.MAIN_HAND));
			}

			return new ActionResult<>(ActionResultType.SUCCESS, item);
//			playerIn.openContainer(new VoidContainer());
		}
	}

	public static class FilterSlot {
		public final int x, y;

		public FilterSlot(int _x, int _y) {
			x = _x;
			y = _y;
		}
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		return new ItemInventory(stack);
	}

	public static ItemInventory getInventory(ItemStack stack) {
		return stack.getCapability(ItemInventory.CAPABILITY).orElseThrow(NullPointerException::new);
	}

	public int getInventorySize(ItemStack filter) {
		return 27;
	}

	public void addSlots(ItemStack filter, List<FilterSlot> list) {
		int columns = 0;

		switch (tier) {
		case BASE:
			columns = 3;
			break;
		case EMPOWERED:
			columns = 6;
			break;
		case EXTREME:
			columns = 9;
			break;
		case OBSCURE:
			columns = 1;
			break;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < columns; j++) {
				list.add(new FilterSlot(8 + 9 * (9 - columns) + j * 18, 16 + i * 18));
			}
		}
	}

	@Override
	public void clearFilterCache(ItemStack filter) {
		// super.clearFilterCache(filter);
		ItemInventory inventory = getInventory(filter);

		for (ItemStack item : inventory.getItems()) {
			IItemFilter f = ItemFiltersAPI.getFilter(item);

			if (f != null) {
				f.clearFilterCache(item);
			}
		}
	}

	@Override
	public void resetFilterData(ItemStack filter) {
		ItemInventory inventory = getInventory(filter);
		inventory.clear();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInfo(ItemStack filter, FilterInfo info, boolean expanded) {
		ItemInventory inventory = getInventory(filter);

		for (ItemStack stack1 : inventory.getItems()) {
			info.add(stack1.getDisplayName());

			if (expanded) {
				IItemFilter filter1 = ItemFiltersAPI.getFilter(stack1);

				if (filter1 != null) {
					info.push();
					filter1.addInfo(stack1, info, expanded);
					info.pop();
				}
			}
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public final void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip,
			ITooltipFlag flag) {
		super.addInformation(stack, world, tooltip, flag);

		if (Screen.hasShiftDown()) {
			tooltip.add(new TranslationTextComponent(I18n.format(getTranslationKey() + ".description"))
					.applyTextStyle(TextFormatting.ITALIC).applyTextStyle(TextFormatting.DARK_GRAY));
		}

		addInfo(stack, new FilterInfoImpl(tooltip), Screen.hasShiftDown());
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockState blockstate = world.getBlockState(blockpos);
		if (blockstate.getBlock() == ModBlocks.quartzPedestal && !blockstate.get(QuartzPedestal.HAS_ACCUMULATOR)
				&& !blockstate.get(QuartzPedestal.HAS_AGITATOR)) {
			ItemStack itemstack = context.getItem();
			QuartzPedestal.insertItem(world, context.getPlayer(), blockpos, blockstate, itemstack);
			world.playEvent((PlayerEntity) null, 1010, blockpos, Item.getIdFromItem(this));
			if (!world.isRemote) {
				itemstack.shrink(1);
			}

			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.PASS;
		}
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		if (stack.hasTag())
			return stack.getTag().getBoolean(voidTag);
		return false;
	}

//	private static class VoidContainer implements INamedContainerProvider {
//
//		@Override
//		public Container createMenu(int i, PlayerInventory inventory, PlayerEntity player) {
//			return ChestContainer.createGeneric9X3(i, inventory);
//		}
//
//		@Override
//		public ITextComponent getDisplayName() {
//			return new StringTextComponent("Item Void");
//		}
//
//	}

	@Override
	public boolean filter(ItemStack filter, ItemStack stack) {
		for (ItemStack item : getInventory(filter).getItems()) {
			if (item.getItem() == stack.getItem() && item.getDamage() == stack.getDamage())
				return true;
		}
		return false;
	}

//	public void destroyItems(ItemStack stack, World worldIn, PlayerEntity playerIn, QuartzPedestalTileEntity pedestal) {
//		if (stack.hasTag() && stack.getTag().getBoolean(voidTag)) {
//			List<ItemEntity> items;
//			BlockPos pos;
//			if (playerIn != null) {
//				pos = playerIn.getPosition();
//			} else if (pedestal != null) {
//				pos = pedestal.getPos();
//			} else {
//				return;
//			}
//			items = worldIn.getEntitiesWithinAABB(ItemEntity.class,
//					new AxisAlignedBB(pos.getX() - getRange(getEnderTier()), pos.getY() - getRange(getEnderTier()),
//							pos.getZ() - getRange(getEnderTier()), pos.getX() + getRange(getEnderTier()),
//							pos.getY() + getRange(getEnderTier()), pos.getZ() + getRange(getEnderTier())),
//					EntityPredicates.NOT_SPECTATING);
//			for (ItemEntity itemEntity : items) {
//				if (playerIn != null) {
//					if (itemEntity.getThrowerId() != playerIn.getUniqueID()) {
//						itemEntity.onCollideWithPlayer(playerIn);
//					}
//				} else if (pedestal != null && !itemEntity.cannotPickup()) {
//					pedestal.addItemStackToInventory(itemEntity.getItem());
//					if (itemEntity.getItem().isEmpty())
//						itemEntity.remove();
//				} else
//					return;
//			}
//		}
//	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof PlayerEntity && !worldIn.isRemote && stack.getOrCreateTag().getBoolean(voidTag)) {
			PlayerEntity player = (PlayerEntity) entityIn;
			int maxDelay = 1;
			int maxDelete = 1;
			switch (tier) {
			case OBSCURE:
				maxDelay = 16;
				maxDelete = 8;
				break;
			case BASE:
				maxDelay = 8;
				maxDelete = 16;
				break;
			case EMPOWERED:
				maxDelay = 4;
				maxDelete = 32;
				break;
			case EXTREME:
				maxDelay = 2;
				maxDelete = 64;
				break;
			}
			if (worldIn.getGameTime() % maxDelay == 0) {
				int i = player.getPersistentData().getInt(voidIndex);
				while (i < player.inventory.mainInventory.size() && player.inventory.mainInventory.get(i).isEmpty())
					i++;
				if (i >= player.inventory.mainInventory.size())
					i = 0;
				if (filter(stack, player.inventory.mainInventory.get(i))) {
					int count = player.inventory.mainInventory.get(i).getCount();
					if (count <= maxDelete)
						player.inventory.mainInventory.get(i).setCount(0);
					else {
						player.inventory.mainInventory.get(i).setCount(count - maxDelete);
						return;
					}
				}
				i++;
				player.getPersistentData().putInt(voidIndex, i);
			}
		}
	}

}
