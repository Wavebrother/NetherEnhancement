package wavebrother.netherenhancement.common.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import wavebrother.netherenhancement.Reference;

@EventBusSubscriber(bus = Bus.MOD, modid = Reference.MOD_ID)
public class ModItems {
	public static Item obscureQuartz;
	@ObjectHolder("minecraft:quartz")
	public static Item quartz;
	public static Item empoweredQuartz;
	public static Item extremeQuartz;
	public static void init() {
	}

	@SubscribeEvent
	public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

		init();
		event.getRegistry().registerAll();
	}

}
