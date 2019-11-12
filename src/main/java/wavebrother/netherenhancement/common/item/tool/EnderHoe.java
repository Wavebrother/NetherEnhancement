package wavebrother.netherenhancement.common.item.tool;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.item.IQuartzItem;
import wavebrother.netherenhancement.common.util.NetherTier;

public class EnderHoe extends HoeItem implements IQuartzItem {

	private static final EnderToolsUtil tool = EnderToolsUtil.HOE;

	public EnderHoe(NetherTier material, String name) {
		super(material.toolTier, tool.getSpeed(material), new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
		setRegistryName(name);
		this.tier = material;
		// TODO Auto-generated constructor stub
	}

	private final NetherTier tier;

	@Override
	public NetherTier getEnderTier() {
		return tier;
	}


}
