package wavebrother.netherenhancement.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class QuartzSlab extends SlabBlock {

	public final EnderBlockItem blockItem;
	public QuartzSlab(QuartzTier tier, String name) {
		super(Block.Properties.from(Blocks.QUARTZ_SLAB));
		setRegistryName(name);
		blockItem = new EnderBlockItem();
	}
	public class EnderBlockItem extends BlockItem{

		protected EnderBlockItem() {
			super(QuartzSlab.this, new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
			setRegistryName(QuartzSlab.this.getRegistryName());
			// TODO Auto-generated constructor stub
		}
		
	}

}
