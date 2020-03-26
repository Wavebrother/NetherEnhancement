package wavebrother.netherenhancement.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class QuartzOre extends OreBlock {

	QuartzTier tier;
	public final QuartzOreItem blockItem;

	public QuartzOre(QuartzTier tier, String name) {
		super(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).hardnessAndResistance(3.0F, 3.0F));
		setRegistryName(name);
		this.tier = tier;
		this.blockItem = new QuartzOreItem();
	}

	public void setupOregen() {
		int frequency = 0;
		switch (tier) {
		case OBSCURE:
			frequency = 4;
			break;
		case EMPOWERED:
			frequency = 3;
			break;
		case EXTREME:
			frequency = 2;
			break;
		default:
			break;
		}
		Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Biome.createDecoratedFeature(Feature.ORE,
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
								this.getDefaultState(), frequency * 2),
						Placement.MAGMA, new FrequencyConfig(frequency)));
	}

	@Override
	protected int getExperience(Random random) {
		switch (tier) {
		case EMPOWERED:
			return MathHelper.nextInt(random, 3, 6);
		case EXTREME:
			return MathHelper.nextInt(random, 4, 8);
		default:
			return 0;
		}
	}

	public class QuartzOreItem extends BlockItem {

		protected QuartzOreItem() {
			super(QuartzOre.this, new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
			setRegistryName(QuartzOre.this.getRegistryName());
		}

	}
}
