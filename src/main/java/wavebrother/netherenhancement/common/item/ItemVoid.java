package wavebrother.netherenhancement.common.item;

import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import wavebrother.netherenhancement.Config;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.blocks.QuartzPedestal;
import wavebrother.netherenhancement.common.init.ModBlocks;
import wavebrother.netherenhancement.common.tiles.QuartzPedestalTileEntity;
import wavebrother.netherenhancement.common.util.QuartzTier;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class ItemVoid extends Item implements IQuartzItem {

	public static final String accumulatorTag = "accumulator";
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
		CompoundNBT NBT = item.getOrCreateTag();
		if (playerIn.isSneaking()) {
			NBT.putBoolean(accumulatorTag, !NBT.getBoolean(accumulatorTag));
			if (NBT.getBoolean(accumulatorTag)) {
				playerIn.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, 1);
			} else {
				playerIn.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, -1);
			}
			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
		} else
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
			return stack.getTag().getBoolean(accumulatorTag);
		return false;
	}

//	@Override
//	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
//		stack.
//		return false;
//	}

	private static int getRange(QuartzTier tier) {
		return Config.ACCUMULATOR_RANGE.get() * Config.ENDER_TIER_MULTIPLIER.get(tier).get();
	}

	public void collectItems(ItemStack stack, World worldIn, PlayerEntity playerIn, QuartzPedestalTileEntity pedestal) {
		if (stack.hasTag() && stack.getTag().getBoolean(accumulatorTag)) {
			List<ItemEntity> items;
			BlockPos pos;
			if (playerIn != null) {
				pos = playerIn.getPosition();
			} else if (pedestal != null) {
				pos = pedestal.getPos();
			} else {
				return;
			}
			items = worldIn.getEntitiesWithinAABB(ItemEntity.class,
					new AxisAlignedBB(pos.getX() - getRange(getQuartzTier()), pos.getY() - getRange(getQuartzTier()),
							pos.getZ() - getRange(getQuartzTier()), pos.getX() + getRange(getQuartzTier()),
							pos.getY() + getRange(getQuartzTier()), pos.getZ() + getRange(getQuartzTier())),
					EntityPredicates.NOT_SPECTATING);
			for (ItemEntity itemEntity : items) {
				if (playerIn != null) {
					if (itemEntity.getThrowerId() != playerIn.getUniqueID()) {
						itemEntity.onCollideWithPlayer(playerIn);
					}
				} else if (pedestal != null && !itemEntity.cannotPickup()) {
					pedestal.addItemStackToInventory(itemEntity.getItem());
					if (itemEntity.getItem().isEmpty())
						itemEntity.remove();
				} else
					return;
			}
		}
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof PlayerEntity && !worldIn.isRemote) {
			collectItems(stack, worldIn, (PlayerEntity) entityIn, null);
		}
	}
}
