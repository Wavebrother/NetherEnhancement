package wavebrother.netherenhancement;

import java.util.Random;

import org.apache.logging.log4j.LogManager;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wavebrother.netherenhancement.common.item.tool.EnderSword;
import wavebrother.netherenhancement.common.util.QuartzTier;

@EventBusSubscriber(bus = Bus.FORGE)
public class MobDropsHandler {

	private static final Random random = new Random();

	@SubscribeEvent
	public void onMobDrops(LivingDropsEvent event) {
		LogManager.getLogger().debug(event.getEntityLiving().getPersistentData().getString(EnderSword.hitTag));
		if (event.getEntity() instanceof EndermanEntity
				&& event.getEntityLiving().getPersistentData().contains(EnderSword.hitTag)) {
			QuartzTier tier = QuartzTier
					.valueOf(event.getEntityLiving().getPersistentData().getString(EnderSword.hitTag));
			if (random.nextDouble() < 1/* / tier.multiplier() */) {
				ItemStack stack = new ItemStack(tier.getQuartz());
				ItemEntity drop = new ItemEntity(event.getEntity().world, event.getEntity().posX,
						event.getEntity().posY, event.getEntity().posZ, stack);

				event.getDrops().add(drop);
			}
		}
	}
}
