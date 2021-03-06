package wavebrother.netherenhancement.common.item;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import wavebrother.netherenhancement.Config;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.util.QuartzTier;
import wavebrother.netherenhancement.common.util.QuartzTier.QuartzArmorMaterial;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class QuartzArmor extends ArmorItem implements IQuartzItem {

	public static final Item COOLDOWNITEM = new Item(new Item.Properties());

	protected final Random rand = new Random();

	static {
		MinecraftForge.EVENT_BUS.register(QuartzArmor.class);
	}

	public QuartzArmor(QuartzTier material, EquipmentSlotType slot, String name) {
		super(material.armorMaterial, slot, new Item.Properties().group(NetherEnhancement.CREATIVE_TAB));
		setRegistryName(name);
		this.tier = material;
		// TODO Auto-generated constructor stub
	}

	private final QuartzTier tier;

	@Override
	public QuartzTier getQuartzTier() {
		return tier;
	}

	@SubscribeEvent
	public static void entityAttacked(LivingAttackEvent event) {
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
	}

	@SuppressWarnings("unused")
	private static boolean checkArmor(ItemStack item, ArrayList<ItemStack> enderArmor, PlayerEntity entity) {
		QuartzArmorMaterial material = QuartzTier.OBSCURE.armorMaterial;
		for (ItemStack armor : entity.getArmorInventoryList()) {
			if (armor.getItem() instanceof QuartzArmor)
				enderArmor.add(armor);
		}
		if (enderArmor.size() == 0)
			return false;
		else if (entity.getCooldownTracker().hasCooldown((QuartzArmor) enderArmor.get(0).getItem()))
			return false;
		if (((QuartzArmor) enderArmor.get(0).getItem()).material instanceof QuartzArmorMaterial)
			material = (QuartzArmorMaterial) ((QuartzArmor) enderArmor.get(0).getItem()).material;
		if (item != null) {
			return false;
		} else {
			return enderArmor.size() >= Config.QUARTZ_ARMOR_ATTACK_MINIMUM.get(material.getTier()).get();
		}
	}

}
