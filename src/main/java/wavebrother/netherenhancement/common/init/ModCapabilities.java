package wavebrother.netherenhancement.common.init;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wavebrother.netherenhancement.Reference;

@EventBusSubscriber(bus = Bus.MOD, modid = Reference.MOD_ID)
public class ModCapabilities {


	public static void init() {
	}

	@SubscribeEvent
	public static void onAttachCapabilities(final AttachCapabilitiesEvent<Entity> event) {
	}
}
