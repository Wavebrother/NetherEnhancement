package wavebrother.netherenhancement.common.item;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import wavebrother.netherenhancement.Config;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.blocks.QuartzPedestal;
import wavebrother.netherenhancement.common.init.ModBlocks;
import wavebrother.netherenhancement.common.util.QuartzTier;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class PigmanAgitator extends Item implements IQuartzItem {

	public static final String agitatorTag = "pigmanAgitator";
	public final QuartzTier tier;

	public PigmanAgitator(QuartzTier tier, String name) {
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
			NBT.putBoolean(agitatorTag, !NBT.getBoolean(agitatorTag));
			if (NBT.getBoolean(agitatorTag)) {
				worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_ZOMBIE_PIGMAN_ANGRY,
						SoundCategory.PLAYERS, 0.15F, 1.2F);
			} else {
				worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_ZOMBIE_PIGMAN_AMBIENT,
						SoundCategory.PLAYERS, 0.25F, 1F);
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
		if (blockstate.getBlock() == ModBlocks.quartzPedestal && !blockstate.get(QuartzPedestal.HAS_AGITATOR)
				&& !blockstate.get(QuartzPedestal.HAS_ACCUMULATOR)) {
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
			return stack.getTag().getBoolean(agitatorTag);
		return false;
	}

//	@Override
//	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
//		stack.
//		return false;
//	}

	public static int getRange(QuartzTier tier) {
		return Config.AGITATOR_RANGE.get() * Config.QUARTZ_TIER_MULTIPLIER.get(tier).get();
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entityIn;
			if (!player.isCreative()) {
				if (stack.hasTag() && stack.getTag().getBoolean(agitatorTag)) {
					List<ZombiePigmanEntity> pigmen = worldIn.getEntitiesWithinAABB(ZombiePigmanEntity.class,
							new AxisAlignedBB(entityIn.posX - getRange(getQuartzTier()),
									entityIn.posY - getRange(getQuartzTier()),
									entityIn.posZ - getRange(getQuartzTier()),
									entityIn.posX + getRange(getQuartzTier()),
									entityIn.posY + getRange(getQuartzTier()),
									entityIn.posZ + getRange(getQuartzTier())),
							EntityPredicates.NOT_SPECTATING);
					for (ZombiePigmanEntity pigman : pigmen) {
						try {
							Method becomeAngryAt = pigman.getClass().getDeclaredMethod("becomeAngryAt");
							becomeAngryAt.invoke(pigman, entityIn);
						} catch (SecurityException | IllegalArgumentException | IllegalAccessException
								| InvocationTargetException | NoSuchMethodException e) {
						}
					}
				} else {
					player.getCooldownTracker().setCooldown(DummyAgitator.INSTANCE, 2);
					player.getPersistentData().putString(agitatorTag, getQuartzTier().name());
				}
			}
		}
	}

	@SubscribeEvent
	public static void onQuartzHit(LivingAttackEvent event) {
		if (event.getSource() instanceof EntityDamageSource
				&& ((EntityDamageSource) event.getSource()).getTrueSource() instanceof ZombiePigmanEntity
				&& event.getEntityLiving() instanceof PlayerEntity) {
			Entity attacker = ((EntityDamageSource) event.getSource()).getTrueSource();
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
			if (player.getCooldownTracker().hasCooldown(DummyAgitator.INSTANCE)) {
				QuartzTier tier = QuartzTier.valueOf(player.getPersistentData().getString(agitatorTag));
				List<ZombiePigmanEntity> endermen = attacker.world.getEntitiesWithinAABB(ZombiePigmanEntity.class,
						new AxisAlignedBB(attacker.posX - getRange(tier), attacker.posY - getRange(tier),
								attacker.posZ - getRange(tier), attacker.posX + getRange(tier),
								attacker.posY + getRange(tier), attacker.posZ + getRange(tier)),
						EntityPredicates.NOT_SPECTATING);
				for (ZombiePigmanEntity pigman : endermen) {
					if (pigman.getAttackTarget() instanceof PlayerEntity) {
						if (pigman.getAttackingEntity() instanceof PlayerEntity) {
							pigman.getCombatTracker().reset();
						}
						pigman.setRevengeTarget(null);
						pigman.setAttackTarget(null);
						try {
							Field angerLevel = pigman.getClass().getDeclaredField("angerLevel");
							angerLevel.setAccessible(true);
							angerLevel.set(pigman, 0);
							Field randomSoundDelay = pigman.getClass().getDeclaredField("randomSoundDelay");
							randomSoundDelay.setAccessible(true);
							randomSoundDelay.set(pigman, 0);
						} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
								| IllegalAccessException e) {
						}
					}
				}
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public static void onQuartzSetAttack(LivingSetAttackTargetEvent event) {
		if (event.getEntityLiving() instanceof ZombiePigmanEntity && event.getTarget() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getTarget();
			if (player.getCooldownTracker().hasCooldown(DummyAgitator.INSTANCE)) {
				((ZombiePigmanEntity) event.getEntityLiving()).setAttackTarget(null);
			}
		}
	}

	public static class DummyAgitator extends Item {
		public static final DummyAgitator INSTANCE = new DummyAgitator();

		private DummyAgitator() {
			super(new Item.Properties());
		}
	}

}
