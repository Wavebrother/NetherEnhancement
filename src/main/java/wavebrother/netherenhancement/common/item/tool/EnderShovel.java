package wavebrother.netherenhancement.common.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.item.IQuartzItem;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class EnderShovel extends ShovelItem implements IQuartzItem {

	private static final EnderToolsUtil tool = EnderToolsUtil.SHOVEL;

	public EnderShovel(QuartzTier material, String name) {
		super(material.toolTier, tool.getDamage(material), tool.getSpeed(material),
				new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
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
