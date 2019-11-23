package wavebrother.netherenhancement.common.item.tool;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.item.IQuartzItem;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class QuartzHoe extends HoeItem implements IQuartzItem {

	private static final QuartzToolsUtil tool = QuartzToolsUtil.HOE;

	public QuartzHoe(QuartzTier material, String name) {
		super(material.toolTier, tool.getSpeed(material), new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
		setRegistryName(name);
		this.tier = material;
		// TODO Auto-generated constructor stub
	}

	private final QuartzTier tier;

	@Override
	public QuartzTier getQuartzTier() {
		return tier;
	}


}
