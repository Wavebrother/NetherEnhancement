package wavebrother.netherenhancement;

import java.nio.file.Path;
import java.util.HashMap;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import wavebrother.netherenhancement.common.util.QuartzTier;

@Mod.EventBusSubscriber
public class Config {

	public static final String CATEGORY_GENERAL = "general";
	public static final String CATEGORY_QUARTZ_ARMOR = "quartz_armor";
	public static final String CATEGORY_QUARTZ_ARMOR_ATTACK = "attack";

	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;

	public static ForgeConfigSpec.BooleanValue HARDMODE;
	public static HashMap<QuartzTier, ForgeConfigSpec.IntValue> QUARTZ_TIER_MULTIPLIER = new HashMap<QuartzTier, ForgeConfigSpec.IntValue>();

	public static ForgeConfigSpec.IntValue AGITATOR_RANGE;

	public static HashMap<QuartzTier, ForgeConfigSpec.IntValue> QUARTZ_ARMOR_ATTACK_MINIMUM = new HashMap<QuartzTier, ForgeConfigSpec.IntValue>();

	static {

		COMMON_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
		for (QuartzTier tier : QuartzTier.values()) {
			QUARTZ_TIER_MULTIPLIER.put(tier, COMMON_BUILDER.comment("Multiplier for " + tier + " tier.")
					.defineInRange(tier.toString().toLowerCase(), tier.defaultMultiplier(), 1, 16));
		}
		AGITATOR_RANGE = COMMON_BUILDER.comment("Agitator range base (Modified by tier multiplier)")
				.defineInRange("agitator_range", 4, 1, 128);
		COMMON_BUILDER.pop();

//		COMMON_BUILDER.comment("Quartz Armor Settings").push(CATEGORY_QUARTZ_ARMOR);
//		COMMON_BUILDER.comment("Attack Settings").push(CATEGORY_QUARTZ_ARMOR_ATTACK);
//		for (QuartzTier tier : QuartzTier.values()) {
//			QUARTZ_ARMOR_ATTACK_MINIMUM.put(tier, COMMON_BUILDER
//					.comment("Minimum number of pieces of " + tier
//							+ " armor to cause a attack teleport.\nSet to 5 to never cause a attack teleport.")
//					.defineInRange(tier.toString().toLowerCase(), tier.armorMaterial.DEFAULT_ATTACK_TP_MIN, 1, 5));
//		}
//		COMMON_BUILDER.pop();

		COMMON_CONFIG = COMMON_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}

	public static void loadConfig(ForgeConfigSpec spec, Path path) {

		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave()
				.writingMode(WritingMode.REPLACE).build();

		configData.load();
		spec.setConfig(configData);
	}

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading configEvent) {

	}

	@SubscribeEvent
	public static void onReload(final ModConfig.ConfigReloading configEvent) {
	}

}
