package wavebrother.netherenhancement.common.item;

import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.util.QuartzTier;

public class Quartz extends Item implements IQuartzItem {

	public Quartz(QuartzTier tier, String name) {
		super(new Properties().maxStackSize(16).group(NetherEnhancement.CREATIVE_TAB));
		setRegistryName(name);
		this.tier = tier;
		// TODO Auto-generated constructor stub
	}

	private final QuartzTier tier;

	@Override
	public QuartzTier getQuartzTier() {
		return tier;
	}

}
