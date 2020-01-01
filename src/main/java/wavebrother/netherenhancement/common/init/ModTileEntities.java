package wavebrother.netherenhancement.common.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.client.renderer.QuartzPedestalTER;
import wavebrother.netherenhancement.common.tiles.QuartzPedestalTileEntity;

@EventBusSubscriber(bus = Bus.MOD, modid = Reference.MOD_ID)
public class ModTileEntities {

	public static TileEntityType<QuartzPedestalTileEntity> quartzPedestal;

	public static void init() {
		quartzPedestal = TileEntityType.Builder.create(QuartzPedestalTileEntity::new, ModBlocks.quartzPedestal)
				.build(null);
		quartzPedestal.setRegistryName(Reference.TileEntities.QUARTZPEDESTAL.getRegistryName());
	}

	@SubscribeEvent
	public static void onTileEntitiesRegistry(final RegistryEvent.Register<TileEntityType<?>> tileEntityRegistryEvent) {
		init();
		tileEntityRegistryEvent.getRegistry().registerAll(quartzPedestal);

		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
			registerRenderers();
		});
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(QuartzPedestalTileEntity.class, new QuartzPedestalTER());
	}
}
