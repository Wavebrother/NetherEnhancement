package wavebrother.netherenhancement.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class QuartzBlock extends Block {

	public final EnderBlockItem blockItem;
	public QuartzBlock(QuartzTier tier, String name) {
		super(Block.Properties.from(Blocks.QUARTZ_BLOCK));
		setRegistryName(name);
		blockItem = new EnderBlockItem();
	}
	public class EnderBlockItem extends BlockItem{

		protected EnderBlockItem() {
			super(QuartzBlock.this, new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
			setRegistryName(QuartzBlock.this.getRegistryName());
			// TODO Auto-generated constructor stub
		}
		
	}

}
