package wavebrother.netherenhancement.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class QuartzPillar extends RotatedPillarBlock {

	public final EnderBlockItem blockItem;
	public QuartzPillar(QuartzTier tier, String name) {
		super(Block.Properties.from(Blocks.IRON_BLOCK).sound(SoundType.ANVIL));
		setRegistryName(name);
		blockItem = new EnderBlockItem();
	}
	public class EnderBlockItem extends BlockItem{

		protected EnderBlockItem() {
			super(QuartzPillar.this, new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
			setRegistryName(QuartzPillar.this.getRegistryName());
			// TODO Auto-generated constructor stub
		}
		
	}

}
