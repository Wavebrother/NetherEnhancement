package wavebrother.netherenhancement.common.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.blocks.QuartzPedestal;
import wavebrother.netherenhancement.common.init.ModBlocks;
import wavebrother.netherenhancement.common.util.QuartzTier;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class ItemVoid extends Item implements IQuartzItem {

	public static final String voidTag = "itemVoid";
	public final QuartzTier tier;

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
//		CompoundNBT NBT = item.getOrCreateTag();
//		if (playerIn.isSneaking()) {
//			NBT.putBoolean(voidTag, !NBT.getBoolean(voidTag));
//			if (NBT.getBoolean(voidTag)) {
//				playerIn.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, 1);
//			} else {
//				playerIn.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, -1);
//			}
//			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
//		} else
		playerIn.openContainer(new VoidContainer());
		return new ActionResult<ItemStack>(ActionResultType.PASS, item);
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

	private static class VoidContainer implements INamedContainerProvider {

		@Override
		public Container createMenu(int i, PlayerInventory inventory, PlayerEntity player) {
			return ChestContainer.createGeneric9X3(i, inventory);
		}

		@Override
		public ITextComponent getDisplayName() {
			return new StringTextComponent("Item Void");
		}

	}

}
