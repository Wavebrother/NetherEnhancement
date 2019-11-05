package wavebrother.netherenhancement.common.item.tool;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.common.item.IEnderItem;
import wavebrother.netherenhancement.common.util.NetherTier;

@EventBusSubscriber(bus = Bus.FORGE)
public class EnderSword extends SwordItem implements IEnderItem {

	private static final EnderToolsUtil tool = EnderToolsUtil.SWORD;

	public static final String hitTag = "HitWithEnderSword";

	static {
		MinecraftForge.EVENT_BUS.register(EnderSword.class);
	}

	public EnderSword(NetherTier material, String name) {
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

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.getPersistentData().putString(hitTag, tier.name());
		target.addTag(hitTag);
		target.addTag(getTagFromTier());
		return super.hitEntity(stack, target, attacker);
	}

	@SubscribeEvent
	public static void onEnderTeleport(EnderTeleportEvent event) {
		if (event.getEntity().getPersistentData().contains(hitTag) || event.getEntity().getTags().contains(hitTag)) {
			event.setCanceled(true);
		}
	}

	public String getTagFromTier() {
		return hitTag + ":" + tier.name();
	}

}
