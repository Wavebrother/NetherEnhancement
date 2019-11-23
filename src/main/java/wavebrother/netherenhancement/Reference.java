package wavebrother.netherenhancement;

public class Reference {

	public static final String MOD_ID = "netherenhancement";
	public static final String NAME = "Nether Enhancement";
	public static final String VERSION = "0.0.0.1";
	public static final String ACCEPTED_VERSIONS = "[1.14.4]";

	public static final String CLIENT_PROXY_CLASS = "wavebrother.netherenhancement.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "wavebrother.netherenhancement.proxy.CommonProxy";

	public static enum Items {

		// Basic Crafting Ingredients
		DULLQUARTZPEARL("item_dull_quartz"), EMPOWEREDQUARTZPEARL("item_empowered_quartz"),
		EXTREMEQUARTZPEARL("item_extreme_quartz"),

		// Sticks
		DULLQUARTZSTICK("item_dull_quartz_stick"), QUARTZSTICK("item_quartz_stick"),
		EMPOWEREDQUARTZSTICK("item_empowered_quartz_stick"), EXTREMEQUARTZSTICK("item_extreme_quartz_stick"),

		// Axes
		DULLQUARTZAXE("item_dull_quartz_axe"), QUARTZAXE("item_quartz_axe"),
		EMPOWEREDQUARTZAXE("item_empowered_quartz_axe"), EXTREMEQUARTZAXE("item_extreme_quartz_axe"),

		// Hoes
		DULLQUARTZHOE("item_dull_quartz_hoe"), QUARTZHOE("item_quartz_hoe"),
		EMPOWEREDQUARTZHOE("item_empowered_quartz_hoe"), EXTREMEQUARTZHOE("item_extreme_quartz_hoe"),

		// Pickaxes
		DULLQUARTZPICKAXE("item_dull_quartz_pickaxe"), QUARTZPICKAXE("item_quartz_pickaxe"),
		EMPOWEREDQUARTZPICKAXE("item_empowered_quartz_pickaxe"), EXTREMEQUARTZPICKAXE("item_extreme_quartz_pickaxe"),

		// Shovels
		DULLQUARTZSHOVEL("item_dull_quartz_shovel"), QUARTZSHOVEL("item_quartz_shovel"),
		EMPOWEREDQUARTZSHOVEL("item_empowered_quartz_shovel"), EXTREMEQUARTZSHOVEL("item_extreme_quartz_shovel"),

		// Swords
		DULLQUARTZSWORD("item_dull_quartz_sword"), QUARTZSWORD("item_quartz_sword"),
		EMPOWEREDQUARTZSWORD("item_empowered_quartz_sword"), EXTREMEQUARTZSWORD("item_extreme_quartz_sword"),

		// Helmets
		DULLQUARTZHELMET("item_dull_quartz_helmet"), QUARTZHELMET("item_quartz_helmet"),
		EMPOWEREDQUARTZHELMET("item_empowered_quartz_helmet"), EXTREMEQUARTZHELMET("item_extreme_quartz_helmet"),

		// Chestplates
		DULLQUARTZCHESTPLATE("item_dull_quartz_chestplate"), QUARTZCHESTPLATE("item_quartz_chestplate"),
		EMPOWEREDQUARTZCHESTPLATE("item_empowered_quartz_chestplate"),
		EXTREMEQUARTZCHESTPLATE("item_extreme_quartz_chestplate"),

		// Leggings
		DULLQUARTZLEGGINGS("item_dull_quartz_leggings"), QUARTZLEGGINGS("item_quartz_leggings"),
		EMPOWEREDQUARTZLEGGINGS("item_empowered_quartz_leggings"),
		EXTREMEQUARTZLEGGINGS("item_extreme_quartz_leggings"),

		// Boots
		DULLQUARTZBOOTS("item_dull_quartz_boots"), QUARTZBOOTS("item_quartz_boots"),
		EMPOWEREDQUARTZBOOTS("item_empowered_quartz_boots"), EXTREMEQUARTZBOOTS("item_extreme_quartz_boots"),

		// Multi Tools
		DULLQUARTZTOOL("item_dull_quartz_tool"), QUARTZTOOL("item_quartz_tool"),
		EMPOWEREDQUARTZTOOL("item_empowered_quartz_tool"), EXTREMEQUARTZTOOL("item_extreme_quartz_tool"),

		// Agitators
		DULLAGITATOR("item_dull_pigman_agitator"), QUARTZAGITATOR("item_quartz_pigman_agitator"),
		EMPOWEREDAGITATOR("item_empowered_pigman_agitator"), EXTREMEAGITATOR("item_extreme_pigman_agitator"),

		// Accumulators
		DULLITEMVOID("item_dull_item_void"), QUARTZITEMVOID("item_quartz_item_void"),
		EMPOWEREDITEMVOID("item_empowered_item_void"), EXTREMEITEMVOID("item_extreme_item_void"),

		// Food
		QUARTZFRUIT("item_quartz_fruit");

		private String registryName;

		Items(String registryName) {
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}

	public static enum Blocks {
		CHISELEDEMPOWEREDQUARTZBLOCK("block_chiseled_empowered_quartz_block"),
		CHISELEDEXTREMEQUARTZBLOCK("block_chiseled_extreme_quartz_block"),
		EMPOWEREDQUARTZBLOCK("block_empowered_quartz_block"), EXTREMEQUARTZBLOCK("block_extreme_quartz_block"),
		EMPOWEREDQUARTZPILLAR("block_empowered_quartz_pillar"), EXTREMEQUARTZPILLAR("block_extreme_quartz_pillar"),
		EMPOWEREDQUARTZSLAB("block_empowered_quartz_slab"), EXTREMEQUARTZSLAB("block_extreme_quartz_slab"),
		EMPOWEREDQUARTZSTAIRS("block_empowered_quartz_stairs"), EXTREMEQUARTZSTAIRS("block_extreme_quartz_stairs"),
		QUARTZPEDESTAL("block_quartz_pedestal");

		private String registryName;

		Blocks(String registryName) {
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}

	public static enum TileEntities {
		QUARTZPEDESTAL("tileentity_quartz_pedestal");

		private String registryName;

		TileEntities(String registryName) {
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}

	public static enum Capabilities {
		QUARTZGYCAPABILITY("capability_quartz_energy");

		private String registryName;

		Capabilities(String registryName) {
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}
}
