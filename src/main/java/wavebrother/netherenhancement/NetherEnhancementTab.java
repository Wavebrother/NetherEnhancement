package wavebrother.netherenhancement;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class NetherEnhancementTab extends ItemGroup{

	public NetherEnhancementTab() {
		super(Reference.MOD_ID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.NETHER_BRICK);
	}

}
