package wavebrother.netherenhancement;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.network.IContainerFactory;
import wavebrother.netherenhancement.common.containers.InventoryFilterContainer;
import wavebrother.netherenhancement.common.util.InventoryFilterScreen;
import wavebrother.netherenhancement.common.init.ModBlocks;

@Mod(value = Reference.MOD_ID)
public class NetherEnhancement {

	public static final ItemGroup CREATIVE_TAB = new NetherEnhancementTab();
	public static final Logger LOGGER = LogManager.getLogger();

	public NetherEnhancement() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

		Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve(Reference.MOD_ID + "-client.toml"));
		Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(Reference.MOD_ID + "-common.toml"));

		// EndermanEntity.death

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ContainerType.class, this::registerContainers);

//		CapabilityManager.INSTANCE.register(CapabilityEndergy.class, new CapabilityEndergy.EndergyStorage(0), factory);
	}

	private void setup(final FMLCommonSetupEvent event) {
		ScreenManager.registerFactory(InventoryFilterContainer.TYPE, InventoryFilterScreen::new);
		ModBlocks.empoweredQuartzOre.setupOregen();
		ModBlocks.extremeQuartzOre.setupOregen();
	}

	private void registerContainers(RegistryEvent.Register<ContainerType<?>> event)
	{
		event.getRegistry().register(new ContainerType<>((IContainerFactory<InventoryFilterContainer>) InventoryFilterContainer::new).setRegistryName("inventory_filter"));
	}

	/**
	 * Only run on the client making it a safe place to register client components.
	 * Remember that you shouldn't reference client only methods in this class as
	 * it'll crash the mod :P
	 */
	private void doClientStuff(final FMLClientSetupEvent event) {
		// Register the container screens.
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
	}

	/**
	 * Intermod communication
	 */
	// Register the enqueueIMC method for modloading
	private void enqueueIMC(final InterModEnqueueEvent event) {
	}

	// Register the processIMC method for modloading
	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
		LOGGER.info("Got IMC {}",
				event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}