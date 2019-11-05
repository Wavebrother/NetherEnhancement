package wavebrother.netherenhancement.common.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import wavebrother.netherenhancement.Config;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.init.ModItems;

public enum NetherTier {
	OBSCURE, BASE, EMPOWERED, EXTREME;
	public final EnderToolTier toolTier;
	public final EnderArmorMaterial armorMaterial;

	NetherTier() {
		toolTier = new EnderToolTier();
		armorMaterial = new EnderArmorMaterial();
	}

	@Override
	public String toString() {
		return super.toString().substring(0, 1) + super.toString().substring(1).toLowerCase();
	}

	public int defaultMultiplier() {
		switch (this) {
		case OBSCURE:
			return 1;
		case BASE:
			return 2;
		case EMPOWERED:
			return 3;
		case EXTREME:
			return 4;
		}
		return 1;
	}

	public int multiplier() {
		return Config.ENDER_TIER_MULTIPLIER.get(this).get();
	}

	public Item getQuartz() {
		switch (this) {
		case OBSCURE:
			return ModItems.obscureQuartz;
		case BASE:
			return ModItems.quartz;
		case EMPOWERED:
			return ModItems.empoweredQuartz;
		case EXTREME:
			return ModItems.extremeQuartz;
		default:
			return null;
		}
	}

	public class EnderToolTier implements IItemTier {

		protected EnderToolTier() {

		}

		public NetherTier enderTier = NetherTier.this;

		public int getMaxUses() {
			switch (NetherTier.this) {
			case OBSCURE:
				return 150;
			case BASE:
				return 250;
			case EMPOWERED:
				return 500;
			case EXTREME:
				return 1000;
			}
			return 0;
		}

		public float getEfficiency() {
			switch (NetherTier.this) {
			case OBSCURE:
				return 4;
			case BASE:
				return 8;
			case EMPOWERED:
				return 12;
			case EXTREME:
				return 16;
			}
			return 0;
		}

		public float getAttackDamage() {
			switch (NetherTier.this) {
			case OBSCURE:
				return 1;
			case BASE:
				return 3;
			case EMPOWERED:
				return 5;
			case EXTREME:
				return 7;
			}
			return 0;
		}

		public int getHarvestLevel() {
			switch (NetherTier.this) {
			case OBSCURE:
				return 1;
			case BASE:
				return 2;
			case EMPOWERED:
				return 3;
			case EXTREME:
				return 4;
			}
			return 0;
		}

		public int getEnchantability() {
			switch (NetherTier.this) {
			case OBSCURE:
				return 10;
			case BASE:
				return 17;
			case EMPOWERED:
				return 24;
			case EXTREME:
				return 31;
			}
			return 0;
		}

		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(getQuartz());
		}
	}

	public class EnderArmorMaterial implements IArmorMaterial {
//		DULL(, , 8, , 0.0F, () -> {
//			return Ingredient.fromItems(Items.LEATHER);
//		}), ENDER(, , , 16, , 0.0F, () -> {
//			return Ingredient.fromItems(Items.IRON_INGOT);
//		}),
//		EMPOWERED(, , , 25, , 0.0F, () -> {
//			return Ingredient.fromItems(Items.IRON_INGOT);
//		}),
//		EXTREME(, , , 35, , 2.0F, () -> {
//			return Ingredient.fromItems(Items.DIAMOND);
//		});

		protected EnderArmorMaterial() {
			DEFAULT_WATER_TP_MIN = DEFAULT_WATER_TP_MINS[getTier().ordinal()];
			DEFAULT_ATTACK_TP_MIN = DEFAULT_ATTACK_TP_MINS[getTier().ordinal()];

		}

		private final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };

		private final int[] DEFAULT_WATER_TP_MINS = { 2, 3, 4, 5 };
		private final int[] DEFAULT_ATTACK_TP_MINS = { 4, 3, 2, 1 };
		public final int DEFAULT_WATER_TP_MIN;
		public final int DEFAULT_ATTACK_TP_MIN;

		public NetherTier getTier() {
			return NetherTier.this;
		}

		public int getDurability(EquipmentSlotType slotIn) {
			int maxDamageFactor = 0;
			switch (NetherTier.this) {
			case OBSCURE:
				maxDamageFactor = 7;
				break;
			case BASE:
				maxDamageFactor = 15;
				break;
			case EMPOWERED:
				maxDamageFactor = 25;
				break;
			case EXTREME:
				maxDamageFactor = 40;
				break;
			}
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * maxDamageFactor;
		}

		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			int[] damageReductionAmountArray = new int[] { 13, 15, 16, 11 };
			switch (NetherTier.this) {
			case OBSCURE:
				damageReductionAmountArray = new int[] { 2, 5, 3, 1 };
				break;
			case BASE:
				damageReductionAmountArray = new int[] { 2, 6, 4, 2 };
				break;
			case EMPOWERED:
				damageReductionAmountArray = new int[] { 3, 7, 5, 2 };
				break;
			case EXTREME:
				damageReductionAmountArray = new int[] { 3, 8, 6, 3 };
				break;
			}
			return damageReductionAmountArray[slotIn.getIndex()];
		}

		public int getEnchantability() {
			switch (NetherTier.this) {
			case OBSCURE:
				return 8;
			case EMPOWERED:
				return 16;
			case BASE:
				return 25;
			case EXTREME:
				return 35;
			}
			return 0;
		}

		public SoundEvent getSoundEvent() {
			switch (NetherTier.this) {
			case OBSCURE:
				return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
			case BASE:
				return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
			case EMPOWERED:
				return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
			case EXTREME:
				return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
			}
			return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
		}

		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(getQuartz());
		}

		public String getName() {
			switch (NetherTier.this) {
			case OBSCURE:
				return Reference.MOD_ID + ":dull_ender";
			case BASE:
				return Reference.MOD_ID + ":ender";
			case EMPOWERED:
				return Reference.MOD_ID + ":empowered_ender";
			case EXTREME:
				return Reference.MOD_ID + ":extreme_ender";
			}
			return "";
		}

		public float getToughness() {
			switch (NetherTier.this) {
			case EXTREME:
				return 2;
			default:
			}
			return 0;
		}
	}
}
