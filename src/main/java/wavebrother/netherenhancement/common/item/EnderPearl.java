package wavebrother.netherenhancement.common.item;

import net.minecraft.item.Item;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.util.NetherTier;

public class EnderPearl extends Item implements IEnderItem {

	public EnderPearl(NetherTier tier, String name) {
		super(new Properties().maxStackSize(16).group(NetherEnhancement.CREATIVE_TAB));
		setRegistryName(name);
		this.tier = tier;
		// TODO Auto-generated constructor stub
	}

	private final NetherTier tier;

	@Override
	public NetherTier getEnderTier() {
		return tier;
	}

}
