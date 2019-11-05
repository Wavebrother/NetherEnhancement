package wavebrother.netherenhancement.common.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.item.IEnderItem;
import wavebrother.netherenhancement.common.util.NetherTier;

public class EnderPickaxe extends PickaxeItem implements IEnderItem {

	private static final EnderToolsUtil tool = EnderToolsUtil.PICKAXE;

	public EnderPickaxe(NetherTier material, String name) {
		super(material.toolTier, tool.getDamage(material).intValue(), tool.getSpeed(material),
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
