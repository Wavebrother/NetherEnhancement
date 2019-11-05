package wavebrother.netherenhancement.common.item.tool;

import java.util.HashMap;
import java.util.Map;

import wavebrother.netherenhancement.common.util.NetherTier;

public enum EnderToolsUtil {
	AXE(new float[] { 5, 6, 6, 7 }, new float[] { -3.2f, -3.2f, -3.0f, -3.0f }),
	PICKAXE(new float[] { 1 }, new float[] { -2.8f }), HOE(new float[] { 0 }, new float[] { -3, -2, -1, 0 }),
	SHOVEL(new float[] { 1.5f }, new float[] { -3 }), SWORD(new float[] { 3 }, new float[] { -2.4f }),
	TOOL(new float[] { 6 }, new float[] { -3.2f });
	private final Map<NetherTier, Float> attackDamage = new HashMap<NetherTier, Float>();
	private final Map<NetherTier, Float> attackSpeed = new HashMap<NetherTier, Float>();

	EnderToolsUtil(float[] damage, float[] speed) {
		for (int i = 0; i < NetherTier.values().length; i++) {
			if (i < damage.length)
				attackDamage.put(NetherTier.values()[i], damage[i]);
			else
				attackDamage.put(NetherTier.values()[i], damage[0]);
			if (i < speed.length)
				attackSpeed.put(NetherTier.values()[i], speed[i]);
			else
				attackSpeed.put(NetherTier.values()[i], speed[0]);
		}
	}

	public Float getDamage(NetherTier tier) {
		return attackDamage.get(tier);
	}

	public Float getSpeed(NetherTier tier) {
		return attackSpeed.get(tier);
	}

//	public TieredItem newEnderTool(EnderTier material, String name) {
//		switch (this) {
//		case AXE:
//			return (AxeItem) new EnderAxe(material.toolTier, attackDamage.get(material),
//					attackSpeed.get(material), new Item.Properties().group(NetherEnhancement.CREATIVE_TAB))
//							.setRegistryName(name);
//		case HOE:
//			return (HoeItem) new HoeItem(material.toolTier, attackSpeed.get(material),
//					new Item.Properties().group(NetherEnhancement.CREATIVE_TAB)).setRegistryName(name);
//		case PICKAXE:
//			return (PickaxeItem) new PickaxeItem(material.toolTier, attackDamage.get(material).intValue(),
//					attackSpeed.get(material), new Item.Properties().group(NetherEnhancement.CREATIVE_TAB))
//							.setRegistryName(name);
//		case SHOVEL:
//			return (ShovelItem) new ShovelItem(material.toolTier, attackDamage.get(material),
//					attackSpeed.get(material), new Item.Properties().group(NetherEnhancement.CREATIVE_TAB))
//							.setRegistryName(name);
//		case SWORD:
//			return (SwordItem) new SwordItem(material.toolTier, attackDamage.get(material).intValue(),
//					attackSpeed.get(material), new Item.Properties().group(NetherEnhancement.CREATIVE_TAB))
//							.setRegistryName(name);
//		case TOOL:
//			break;
//		}
//		return null;
//	}

}
