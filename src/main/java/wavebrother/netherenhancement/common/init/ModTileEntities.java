package wavebrother.netherenhancement.common.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.tiles.EnderPedestalTileEntity;

@EventBusSubscriber(bus = Bus.MOD, modid = Reference.MOD_ID)
public class ModTileEntities {

	public static TileEntityType<EnderPedestalTileEntity> enderPedestal;

	public static void init() {
		enderPedestal = TileEntityType.Builder.create(EnderPedestalTileEntity::new, ModBlocks.enderPedestal)
				.build(null);
		enderPedestal.setRegistryName(Reference.TileEntities.ENDERPEDESTAL.getRegistryName());
	}

	@SubscribeEvent
	public static void onTileEntitiesRegistry(final RegistryEvent.Register<TileEntityType<?>> tileEntityRegistryEvent) {
		init();
		tileEntityRegistryEvent.getRegistry().registerAll(enderPedestal);

//		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
//			registerRenderers();
//		});
	}

//	@OnlyIn(Dist.CLIENT)
//	public static void registerRenderers() {
//	}
}
