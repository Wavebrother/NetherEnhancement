package wavebrother.netherenhancement.common.init;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.blocks.QuartzBlock;
import wavebrother.netherenhancement.common.blocks.QuartzPedestal;
import wavebrother.netherenhancement.common.blocks.QuartzPillar;
import wavebrother.netherenhancement.common.blocks.QuartzSlab;
import wavebrother.netherenhancement.common.blocks.QuartzStairs;
import wavebrother.netherenhancement.common.util.QuartzTier;

@EventBusSubscriber(bus = Bus.MOD, modid = Reference.MOD_ID)
public class ModBlocks {

	public static QuartzBlock empoweredChiseledQuartzBlock;
	public static QuartzBlock extremeChiseledQuartzBlock;

	public static QuartzBlock empoweredQuartzBlock;
	public static QuartzBlock extremeQuartzBlock;

	public static QuartzPillar empoweredQuartzPillar;
	public static QuartzPillar extremeQuartzPillar;

	public static QuartzSlab empoweredQuartzSlab;
	public static QuartzSlab extremeQuartzSlab;

	public static QuartzStairs empoweredQuartzStairs;
	public static QuartzStairs extremeQuartzStairs;

	public static QuartzPedestal quartzPedestal;

	public static void init() {
		empoweredChiseledQuartzBlock = new QuartzBlock(QuartzTier.EMPOWERED,
				Reference.Blocks.CHISELEDEMPOWEREDQUARTZBLOCK.getRegistryName());
		extremeChiseledQuartzBlock = new QuartzBlock(QuartzTier.EXTREME,
				Reference.Blocks.CHISELEDEXTREMEQUARTZBLOCK.getRegistryName());
		empoweredQuartzBlock = new QuartzBlock(QuartzTier.EMPOWERED,
				Reference.Blocks.EMPOWEREDQUARTZBLOCK.getRegistryName());
		extremeQuartzBlock = new QuartzBlock(QuartzTier.EXTREME, Reference.Blocks.EXTREMEQUARTZBLOCK.getRegistryName());
		empoweredQuartzPillar = new QuartzPillar(QuartzTier.EMPOWERED,
				Reference.Blocks.EMPOWEREDQUARTZPILLAR.getRegistryName());
		extremeQuartzPillar = new QuartzPillar(QuartzTier.EXTREME,
				Reference.Blocks.EXTREMEQUARTZPILLAR.getRegistryName());
		empoweredQuartzSlab = new QuartzSlab(QuartzTier.EMPOWERED,
				Reference.Blocks.EMPOWEREDQUARTZSLAB.getRegistryName());
		extremeQuartzSlab = new QuartzSlab(QuartzTier.EXTREME, Reference.Blocks.EXTREMEQUARTZSLAB.getRegistryName());
		empoweredQuartzStairs = new QuartzStairs(empoweredQuartzBlock,
				Reference.Blocks.EMPOWEREDQUARTZSTAIRS.getRegistryName());
		extremeQuartzStairs = new QuartzStairs(extremeQuartzBlock,
				Reference.Blocks.EXTREMEQUARTZSTAIRS.getRegistryName());
		quartzPedestal = new QuartzPedestal(Reference.Blocks.QUARTZPEDESTAL.getRegistryName());
	}

	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
		init();
//		NetherEnhancement.LOGGER.info("REGISTER THE BLOCKS\n\n\n\n\n\n\n\nREGISTER THE BLOCKS");
//		System.out.println("REGISTER THE BLOCKS\n\n\n\n\n\n\n\nREGISTER THE BLOCKS");
		blockRegistryEvent.getRegistry().registerAll(empoweredChiseledQuartzBlock, extremeChiseledQuartzBlock,
				empoweredQuartzBlock, extremeQuartzBlock, empoweredQuartzPillar, extremeQuartzPillar,
				empoweredQuartzSlab, extremeQuartzSlab, empoweredQuartzStairs, extremeQuartzStairs, quartzPedestal);
	}

//	public static void registerRenders(){
//		registerRender(dullQuartzBlock);
//		registerRender(enderBlock);
//		registerRender(empoweredQuartzBlock);
//		registerRender(extremeQuartzBlock);
//	}

//	private static void registerRender(Block block){
//		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block),  0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
//	
//	}
//    @OnlyIn(Dist.CLIENT)
//    public static void registerRenderers() {
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(event -> {
//            ClientRegistry.bindTileEntitySpecialRenderer(RenderBlockTileEntity.class, new RenderBlockTER());
//        });
//    }
}
