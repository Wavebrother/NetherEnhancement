package wavebrother.netherenhancement.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;

public class QuartzStairs extends StairsBlock {

	public final EnderBlockItem blockItem;
	public QuartzStairs(QuartzBlock base, String name) {
		super(() -> base.getDefaultState(), Block.Properties.from(Blocks.QUARTZ_STAIRS));
		setRegistryName(name);
		blockItem = new EnderBlockItem();
	}
	public class EnderBlockItem extends BlockItem{

		protected EnderBlockItem() {
			super(QuartzStairs.this, new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
			setRegistryName(QuartzStairs.this.getRegistryName());
			// TODO Auto-generated constructor stub
		}
		
	}

}
