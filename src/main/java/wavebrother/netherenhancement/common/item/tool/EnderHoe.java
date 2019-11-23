package wavebrother.netherenhancement.common.item.tool;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.item.IQuartzItem;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class EnderHoe extends HoeItem implements IQuartzItem {

	private static final EnderToolsUtil tool = EnderToolsUtil.HOE;

	public EnderHoe(QuartzTier material, String name) {
		super(material.toolTier, tool.getSpeed(material), new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
		setRegistryName(name);
		this.tier = material;
		// TODO Auto-generated constructor stub
	}

	private final QuartzTier tier;

	@Override
	public QuartzTier getEnderTier() {
		return tier;
	}


}
