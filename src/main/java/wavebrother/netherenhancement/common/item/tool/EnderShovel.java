package wavebrother.netherenhancement.common.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.item.IEnderItem;
import wavebrother.netherenhancement.common.util.NetherTier;

public class EnderShovel extends ShovelItem implements IEnderItem {

	private static final EnderToolsUtil tool = EnderToolsUtil.SHOVEL;

	public EnderShovel(NetherTier material, String name) {
		super(material.toolTier, tool.getDamage(material), tool.getSpeed(material),
				new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
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
