package wavebrother.netherenhancement.common.init;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.blocks.QuartzBlock;
import wavebrother.netherenhancement.common.blocks.QuartzOre;
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

	public static QuartzOre empoweredQuartzOre;
	public static QuartzOre extremeQuartzOre;

	public static QuartzPedestal quartzPedestal;
	
	public static ArrayList<Block> blocks = new ArrayList<Block>();

	public static void init() {
		blocks.add(empoweredChiseledQuartzBlock = new QuartzBlock(QuartzTier.EMPOWERED,
				Reference.Blocks.CHISELEDEMPOWEREDQUARTZBLOCK.getRegistryName()));
		blocks.add(extremeChiseledQuartzBlock = new QuartzBlock(QuartzTier.EXTREME,
				Reference.Blocks.CHISELEDEXTREMEQUARTZBLOCK.getRegistryName()));

		blocks.add(empoweredQuartzBlock = new QuartzBlock(QuartzTier.EMPOWERED,
				Reference.Blocks.EMPOWEREDQUARTZBLOCK.getRegistryName()));
		blocks.add(extremeQuartzBlock = new QuartzBlock(QuartzTier.EXTREME, Reference.Blocks.EXTREMEQUARTZBLOCK.getRegistryName()));

		blocks.add(empoweredQuartzPillar = new QuartzPillar(QuartzTier.EMPOWERED,
				Reference.Blocks.EMPOWEREDQUARTZPILLAR.getRegistryName()));
		blocks.add(extremeQuartzPillar = new QuartzPillar(QuartzTier.EXTREME,
				Reference.Blocks.EXTREMEQUARTZPILLAR.getRegistryName()));

		blocks.add(empoweredQuartzSlab = new QuartzSlab(QuartzTier.EMPOWERED,
				Reference.Blocks.EMPOWEREDQUARTZSLAB.getRegistryName()));
		blocks.add(extremeQuartzSlab = new QuartzSlab(QuartzTier.EXTREME, Reference.Blocks.EXTREMEQUARTZSLAB.getRegistryName()));

		blocks.add(empoweredQuartzStairs = new QuartzStairs(empoweredQuartzBlock,
				Reference.Blocks.EMPOWEREDQUARTZSTAIRS.getRegistryName()));
		blocks.add(extremeQuartzStairs = new QuartzStairs(extremeQuartzBlock,
				Reference.Blocks.EXTREMEQUARTZSTAIRS.getRegistryName()));

		blocks.add(empoweredQuartzOre = new QuartzOre(QuartzTier.EMPOWERED,
				Reference.Blocks.EMPOWERED_QUARTZ_ORE.getRegistryName()));
		blocks.add(extremeQuartzOre = new QuartzOre(QuartzTier.EXTREME, Reference.Blocks.EXTREME_QUARTZ_ORE.getRegistryName()));

		blocks.add(quartzPedestal = new QuartzPedestal(Reference.Blocks.QUARTZPEDESTAL.getRegistryName()));
	}

	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
		init();
//		NetherEnhancement.LOGGER.info("REGISTER THE BLOCKS\n\n\n\n\n\n\n\nREGISTER THE BLOCKS");
//		System.out.println("REGISTER THE BLOCKS\n\n\n\n\n\n\n\nREGISTER THE BLOCKS");
		blockRegistryEvent.getRegistry().registerAll(empoweredChiseledQuartzBlock, extremeChiseledQuartzBlock,
				empoweredQuartzBlock, extremeQuartzBlock, empoweredQuartzPillar, extremeQuartzPillar,
				empoweredQuartzSlab, extremeQuartzSlab, empoweredQuartzStairs, extremeQuartzStairs, empoweredQuartzOre,
				extremeQuartzOre, quartzPedestal);
//		for(Block block: blocks) {
//			LootTableList.register(new ResourceLocation())
//		}
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
