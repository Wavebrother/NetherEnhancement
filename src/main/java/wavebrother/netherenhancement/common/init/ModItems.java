package wavebrother.netherenhancement.common.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.item.ItemQuartzFruit;
import wavebrother.netherenhancement.common.item.ItemVoid;
import wavebrother.netherenhancement.common.item.PigmanAgitator;
import wavebrother.netherenhancement.common.item.Quartz;
import wavebrother.netherenhancement.common.item.QuartzArmor;
import wavebrother.netherenhancement.common.item.QuartzStick;
import wavebrother.netherenhancement.common.item.tool.QuartzAxe;
import wavebrother.netherenhancement.common.item.tool.QuartzHoe;
import wavebrother.netherenhancement.common.item.tool.QuartzMultiTool;
import wavebrother.netherenhancement.common.item.tool.QuartzPickaxe;
import wavebrother.netherenhancement.common.item.tool.QuartzShovel;
import wavebrother.netherenhancement.common.item.tool.QuartzSword;
import wavebrother.netherenhancement.common.util.QuartzTier;

@EventBusSubscriber(bus = Bus.MOD, modid = Reference.MOD_ID)
public class ModItems {
	public static Item obscureQuartz;
	@ObjectHolder("minecraft:quartz")
	public static Item quartz;
	public static Item empoweredQuartz;
	public static Item extremeQuartz;

	// Sticks
	public static Item dullQuartzStick;
	public static Item quartzStick;
	public static Item empoweredQuartzStick;
	public static Item extremeQuartzStick;

	// Axes
	public static Item dullQuartzAxe;
	public static Item quartzAxe;
	public static Item empoweredQuartzAxe;
	public static Item extremeQuartzAxe;

	// Hoes
	public static Item dullQuartzHoe;
	public static Item quartzHoe;
	public static Item empoweredQuartzHoe;
	public static Item extremeQuartzHoe;

	// Pickaxes
	public static Item dullQuartzPickaxe;
	public static Item quartzPickaxe;
	public static Item empoweredQuartzPickaxe;
	public static Item extremeQuartzPickaxe;

	// Shovels
	public static Item dullQuartzShovel;
	public static Item quartzShovel;
	public static Item empoweredQuartzShovel;
	public static Item extremeQuartzShovel;

	// Swords
	public static Item dullQuartzSword;
	public static Item quartzSword;
	public static Item empoweredQuartzSword;
	public static Item extremeQuartzSword;

	// Helmets
	public static Item dullQuartzHelmet;
	public static Item quartzHelmet;
	public static Item empoweredQuartzHelmet;
	public static Item extremeQuartzHelmet;

	// Chestplates
	public static Item dullQuartzChestplate;
	public static Item quartzChestplate;
	public static Item empoweredQuartzChestplate;
	public static Item extremeQuartzChestplate;

	// Leggings
	public static Item dullQuartzLeggings;
	public static Item quartzLeggings;
	public static Item empoweredQuartzLeggings;
	public static Item extremeQuartzLeggings;

	// Boots
	public static Item dullQuartzBoots;
	public static Item quartzBoots;
	public static Item empoweredQuartzBoots;
	public static Item extremeQuartzBoots;

	// Multi Tools
	public static Item dullQuartzTool;
	public static Item quartzTool;
	public static Item empoweredQuartzTool;
	public static Item extremeQuartzTool;

	// Porters
	public static Item dullQuartzPorter;
	public static Item quartzPorter;
	public static Item empoweredQuartzPorter;
	public static Item extremeQuartzPorter;

	// Agitators
	public static Item dullQuartzAgitator;
	public static Item quartzAgitator;
	public static Item empoweredQuartzAgitator;
	public static Item extremeQuartzAgitator;

	// Voids
	public static Item dullVoid;
	public static Item quartzVoid;
	public static Item empoweredVoid;
	public static Item extremeVoid;

//	// Quartzgy Collectors
//	public static Item dullQuartzgyCollector;
//	public static Item quartzgyCollector;
//	public static Item empoweredQuartzgyCollector;
//	public static Item extremeQuartzgyCollector;

	// Food
	public static Item quartzFruit;
	public static Item dullBlockPorter;

	public static void init() {

		// Pearls
		empoweredQuartz = new Quartz(QuartzTier.EMPOWERED, Reference.Items.EMPOWEREDQUARTZPEARL.getRegistryName());
		extremeQuartz = new Quartz(QuartzTier.EXTREME, Reference.Items.EXTREMEQUARTZPEARL.getRegistryName());

		// Sticks
		dullQuartzStick = new QuartzStick(QuartzTier.OBSCURE, Reference.Items.DULLQUARTZSTICK.getRegistryName());
		quartzStick = new QuartzStick(QuartzTier.BASE, Reference.Items.QUARTZSTICK.getRegistryName());
		empoweredQuartzStick = new QuartzStick(QuartzTier.EMPOWERED,
				Reference.Items.EMPOWEREDQUARTZSTICK.getRegistryName());
		extremeQuartzStick = new QuartzStick(QuartzTier.EXTREME, Reference.Items.EXTREMEQUARTZSTICK.getRegistryName());

		// Axes
		dullQuartzAxe = new QuartzAxe(QuartzTier.OBSCURE, Reference.Items.DULLQUARTZAXE.getRegistryName());
		quartzAxe = new QuartzAxe(QuartzTier.BASE, Reference.Items.QUARTZAXE.getRegistryName());
		empoweredQuartzAxe = new QuartzAxe(QuartzTier.EMPOWERED, Reference.Items.EMPOWEREDQUARTZAXE.getRegistryName());
		extremeQuartzAxe = new QuartzAxe(QuartzTier.EXTREME, Reference.Items.EXTREMEQUARTZAXE.getRegistryName());

		// Hoes
		dullQuartzHoe = new QuartzHoe(QuartzTier.OBSCURE, Reference.Items.DULLQUARTZHOE.getRegistryName());
		quartzHoe = new QuartzHoe(QuartzTier.BASE, Reference.Items.QUARTZHOE.getRegistryName());
		empoweredQuartzHoe = new QuartzHoe(QuartzTier.EMPOWERED, Reference.Items.EMPOWEREDQUARTZHOE.getRegistryName());
		extremeQuartzHoe = new QuartzHoe(QuartzTier.EXTREME, Reference.Items.EXTREMEQUARTZHOE.getRegistryName());

		// Pickaxes
		dullQuartzPickaxe = new QuartzPickaxe(QuartzTier.OBSCURE, Reference.Items.DULLQUARTZPICKAXE.getRegistryName());
		quartzPickaxe = new QuartzPickaxe(QuartzTier.BASE, Reference.Items.QUARTZPICKAXE.getRegistryName());
		empoweredQuartzPickaxe = new QuartzPickaxe(QuartzTier.EMPOWERED,
				Reference.Items.EMPOWEREDQUARTZPICKAXE.getRegistryName());
		extremeQuartzPickaxe = new QuartzPickaxe(QuartzTier.EXTREME,
				Reference.Items.EXTREMEQUARTZPICKAXE.getRegistryName());

		// Shovels
		dullQuartzShovel = new QuartzShovel(QuartzTier.OBSCURE, Reference.Items.DULLQUARTZSHOVEL.getRegistryName());
		quartzShovel = new QuartzShovel(QuartzTier.BASE, Reference.Items.QUARTZSHOVEL.getRegistryName());
		empoweredQuartzShovel = new QuartzShovel(QuartzTier.EMPOWERED,
				Reference.Items.EMPOWEREDQUARTZSHOVEL.getRegistryName());
		extremeQuartzShovel = new QuartzShovel(QuartzTier.EXTREME,
				Reference.Items.EXTREMEQUARTZSHOVEL.getRegistryName());

		// Swords
		dullQuartzSword = new QuartzSword(QuartzTier.OBSCURE, Reference.Items.DULLQUARTZSWORD.getRegistryName());
		quartzSword = new QuartzSword(QuartzTier.BASE, Reference.Items.QUARTZSWORD.getRegistryName());
		empoweredQuartzSword = new QuartzSword(QuartzTier.EMPOWERED,
				Reference.Items.EMPOWEREDQUARTZSWORD.getRegistryName());
		extremeQuartzSword = new QuartzSword(QuartzTier.EXTREME, Reference.Items.EXTREMEQUARTZSWORD.getRegistryName());

		// Helmets
		dullQuartzHelmet = new QuartzArmor(QuartzTier.OBSCURE, EquipmentSlotType.HEAD,
				Reference.Items.DULLQUARTZHELMET.getRegistryName());
		quartzHelmet = new QuartzArmor(QuartzTier.BASE, EquipmentSlotType.HEAD,
				Reference.Items.QUARTZHELMET.getRegistryName());
		empoweredQuartzHelmet = new QuartzArmor(QuartzTier.EMPOWERED, EquipmentSlotType.HEAD,
				Reference.Items.EMPOWEREDQUARTZHELMET.getRegistryName());
		extremeQuartzHelmet = new QuartzArmor(QuartzTier.EXTREME, EquipmentSlotType.HEAD,
				Reference.Items.EXTREMEQUARTZHELMET.getRegistryName());

		// Chestplates
		dullQuartzChestplate = new QuartzArmor(QuartzTier.OBSCURE, EquipmentSlotType.CHEST,
				Reference.Items.DULLQUARTZCHESTPLATE.getRegistryName());
		quartzChestplate = new QuartzArmor(QuartzTier.BASE, EquipmentSlotType.CHEST,
				Reference.Items.QUARTZCHESTPLATE.getRegistryName());
		empoweredQuartzChestplate = new QuartzArmor(QuartzTier.EMPOWERED, EquipmentSlotType.CHEST,
				Reference.Items.EMPOWEREDQUARTZCHESTPLATE.getRegistryName());
		extremeQuartzChestplate = new QuartzArmor(QuartzTier.EXTREME, EquipmentSlotType.CHEST,
				Reference.Items.EXTREMEQUARTZCHESTPLATE.getRegistryName());

		// Leggings
		dullQuartzLeggings = new QuartzArmor(QuartzTier.OBSCURE, EquipmentSlotType.LEGS,
				Reference.Items.DULLQUARTZLEGGINGS.getRegistryName());
		quartzLeggings = new QuartzArmor(QuartzTier.BASE, EquipmentSlotType.LEGS,
				Reference.Items.QUARTZLEGGINGS.getRegistryName());
		empoweredQuartzLeggings = new QuartzArmor(QuartzTier.EMPOWERED, EquipmentSlotType.LEGS,
				Reference.Items.EMPOWEREDQUARTZLEGGINGS.getRegistryName());
		extremeQuartzLeggings = new QuartzArmor(QuartzTier.EXTREME, EquipmentSlotType.LEGS,
				Reference.Items.EXTREMEQUARTZLEGGINGS.getRegistryName());

		// Boots
		dullQuartzBoots = new QuartzArmor(QuartzTier.OBSCURE, EquipmentSlotType.FEET,
				Reference.Items.DULLQUARTZBOOTS.getRegistryName());
		quartzBoots = new QuartzArmor(QuartzTier.BASE, EquipmentSlotType.FEET,
				Reference.Items.QUARTZBOOTS.getRegistryName());
		empoweredQuartzBoots = new QuartzArmor(QuartzTier.EMPOWERED, EquipmentSlotType.FEET,
				Reference.Items.EMPOWEREDQUARTZBOOTS.getRegistryName());
		extremeQuartzBoots = new QuartzArmor(QuartzTier.EXTREME, EquipmentSlotType.FEET,
				Reference.Items.EXTREMEQUARTZBOOTS.getRegistryName());

		// Multi Tools
		dullQuartzTool = new QuartzMultiTool(QuartzTier.OBSCURE, Reference.Items.DULLQUARTZTOOL.getRegistryName());
		quartzTool = new QuartzMultiTool(QuartzTier.BASE, Reference.Items.QUARTZTOOL.getRegistryName());
		empoweredQuartzTool = new QuartzMultiTool(QuartzTier.EMPOWERED,
				Reference.Items.EMPOWEREDQUARTZTOOL.getRegistryName());
		extremeQuartzTool = new QuartzMultiTool(QuartzTier.EXTREME,
				Reference.Items.EXTREMEQUARTZTOOL.getRegistryName());

		// Voids
		dullVoid = new ItemVoid(QuartzTier.OBSCURE, Reference.Items.DULLITEMVOID.getRegistryName());
		quartzVoid = new ItemVoid(QuartzTier.BASE, Reference.Items.QUARTZITEMVOID.getRegistryName());
		empoweredVoid = new ItemVoid(QuartzTier.EMPOWERED, Reference.Items.EMPOWEREDITEMVOID.getRegistryName());
		extremeVoid = new ItemVoid(QuartzTier.EXTREME, Reference.Items.EXTREMEITEMVOID.getRegistryName());

		// Agitators
		dullQuartzAgitator = new PigmanAgitator(QuartzTier.OBSCURE, Reference.Items.DULLAGITATOR.getRegistryName());
		quartzAgitator = new PigmanAgitator(QuartzTier.BASE, Reference.Items.QUARTZAGITATOR.getRegistryName());
		empoweredQuartzAgitator = new PigmanAgitator(QuartzTier.EMPOWERED,
				Reference.Items.EMPOWEREDAGITATOR.getRegistryName());
		extremeQuartzAgitator = new PigmanAgitator(QuartzTier.EXTREME,
				Reference.Items.EXTREMEAGITATOR.getRegistryName());

//		// QuartzgyCollectors
//		dullQuartzgyCollector = new QuartzgyCollector(QuartzTier.OBSCURE, Reference.Items.DULLQUARTZGYCOLLECTOR.getRegistryName());
//		quartzgyCollector = new QuartzgyCollector(QuartzTier.BASE, Reference.Items.QUARTZGYCOLLECTOR.getRegistryName());
//		empoweredQuartzgyCollector = new QuartzgyCollector(QuartzTier.EMPOWERED,
//				Reference.Items.EMPOWEREDQUARTZGYCOLLECTOR.getRegistryName());
//		extremeQuartzgyCollector = new QuartzgyCollector(QuartzTier.EXTREME, Reference.Items.EXTREMEQUARTZGYCOLLECTOR.getRegistryName());

		// Food
		quartzFruit = new ItemQuartzFruit();

	}

	@SubscribeEvent
	public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

		init();
		// Pearls
		event.getRegistry().registerAll(
				// Quartz
				quartzStick, quartzAxe, quartzHoe, quartzPickaxe, quartzShovel, quartzSword, quartzHelmet,
				quartzChestplate, quartzLeggings, quartzBoots, quartzAgitator, quartzVoid, quartzTool,
				// Empowered
				empoweredQuartz, empoweredQuartzStick, empoweredQuartzAxe, empoweredQuartzHoe, empoweredQuartzPickaxe,
				empoweredQuartzShovel, empoweredQuartzSword, empoweredQuartzHelmet, empoweredQuartzChestplate,
				empoweredQuartzLeggings, empoweredQuartzBoots, empoweredQuartzAgitator, empoweredVoid,
				empoweredQuartzTool,
				// Extreme
				extremeQuartz, extremeQuartzStick, extremeQuartzAxe, extremeQuartzHoe, extremeQuartzPickaxe,
				extremeQuartzShovel, extremeQuartzSword, extremeQuartzHelmet, extremeQuartzChestplate,
				extremeQuartzLeggings, extremeQuartzBoots, extremeQuartzAgitator, extremeVoid, extremeQuartzTool,

				// Food
				quartzFruit,

				// Blocks
				ModBlocks.empoweredChiseledQuartzBlock.blockItem, ModBlocks.extremeChiseledQuartzBlock.blockItem,
				ModBlocks.empoweredQuartzBlock.blockItem, ModBlocks.extremeQuartzBlock.blockItem,
				ModBlocks.empoweredQuartzPillar.blockItem, ModBlocks.extremeQuartzPillar.blockItem,
			ModBlocks.empoweredQuartzSlab.blockItem, ModBlocks.extremeQuartzSlab.blockItem,
				ModBlocks.empoweredQuartzStairs.blockItem, ModBlocks.extremeQuartzStairs.blockItem,
				ModBlocks.quartzPedestal.blockItem);
	}
}
