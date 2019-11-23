package wavebrother.netherenhancement.common.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.item.IQuartzItem;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class QuartzPickaxe extends PickaxeItem implements IQuartzItem {

	private static final QuartzToolsUtil tool = QuartzToolsUtil.PICKAXE;

	public QuartzPickaxe(QuartzTier material, String name) {
		super(material.toolTier, tool.getDamage(material).intValue(), tool.getSpeed(material),
				new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
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
