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
		DULLENDERPEARL("item_dull_quartz_pearl"), EMPOWEREDENDERPEARL("item_empowered_quartz_pearl"),
		EXTREMEENDERPEARL("item_extreme_quartz_pearl"),

		// Sticks
		DULLENDERSTICK("item_dull_quartz_stick"), ENDERSTICK("item_quartz_stick"),
		EMPOWEREDENDERSTICK("item_empowered_quartz_stick"), EXTREMEENDERSTICK("item_extreme_quartz_stick"),

		// Axes
		DULLENDERAXE("item_dull_quartz_axe"), ENDERAXE("item_quartz_axe"), EMPOWEREDENDERAXE("item_empowered_quartz_axe"),
		EXTREMEENDERAXE("item_extreme_quartz_axe"),

		// Hoes
		DULLENDERHOE("item_dull_quartz_hoe"), ENDERHOE("item_quartz_hoe"), EMPOWEREDENDERHOE("item_empowered_quartz_hoe"),
		EXTREMEENDERHOE("item_extreme_quartz_hoe"),

		// Pickaxes
		DULLENDERPICKAXE("item_dull_quartz_pickaxe"), ENDERPICKAXE("item_quartz_pickaxe"),
		EMPOWEREDENDERPICKAXE("item_empowered_quartz_pickaxe"), EXTREMEENDERPICKAXE("item_extreme_quartz_pickaxe"),

		// Shovels
		DULLENDERSHOVEL("item_dull_quartz_shovel"), ENDERSHOVEL("item_quartz_shovel"),
		EMPOWEREDENDERSHOVEL("item_empowered_quartz_shovel"), EXTREMEENDERSHOVEL("item_extreme_quartz_shovel"),

		// Swords
		DULLENDERSWORD("item_dull_quartz_sword"), ENDERSWORD("item_quartz_sword"),
		EMPOWEREDENDERSWORD("item_empowered_quartz_sword"), EXTREMEENDERSWORD("item_extreme_quartz_sword"),

		// Helmets
		DULLENDERHELMET("item_dull_quartz_helmet"), ENDERHELMET("item_quartz_helmet"),
		EMPOWEREDENDERHELMET("item_empowered_quartz_helmet"), EXTREMEENDERHELMET("item_extreme_quartz_helmet"),

		// Chestplates
		DULLENDERCHESTPLATE("item_dull_quartz_chestplate"), ENDERCHESTPLATE("item_quartz_chestplate"),
		EMPOWEREDENDERCHESTPLATE("item_empowered_quartz_chestplate"),
		EXTREMEENDERCHESTPLATE("item_extreme_quartz_chestplate"),

		// Leggings
		DULLENDERLEGGINGS("item_dull_quartz_leggings"), ENDERLEGGINGS("item_quartz_leggings"),
		EMPOWEREDENDERLEGGINGS("item_empowered_quartz_leggings"), EXTREMEENDERLEGGINGS("item_extreme_quartz_leggings"),

		// Boots
		DULLENDERBOOTS("item_dull_quartz_boots"), ENDERBOOTS("item_quartz_boots"),
		EMPOWEREDENDERBOOTS("item_empowered_quartz_boots"), EXTREMEENDERBOOTS("item_extreme_quartz_boots"),

		// Multi Tools
		DULLENDERTOOL("item_dull_quartz_tool"), ENDERTOOL("item_quartz_tool"),
		EMPOWEREDENDERTOOL("item_empowered_quartz_tool"), EXTREMEENDERTOOL("item_extreme_quartz_tool"),

		// Porters
		DULLENDERPORTER("item_dull_quartz_porter"), ENDERPORTER("item_quartz_pearler"),
		EMPOWEREDENDERPORTER("item_empowered_quartz_porter"), EXTREMEENDERPORTER("item_extreme_quartz_porter"),

		// Agitators
		DULLENDERAGITATOR("item_dull_quartzman_agitator"), ENDERAGITATOR("item_quartzman_agitator"),
		EMPOWEREDENDERAGITATOR("item_empowered_quartzman_agitator"),
		EXTREMEENDERAGITATOR("item_extreme_quartzman_agitator"),

		// Accumulators
		DULLITEMACCUMULATOR("item_dull_item_accumulator"), ENDERITEMACCUMULATOR("item_quartz_item_accumulator"),
		EMPOWEREDITEMACCUMULATOR("item_empowered_item_accumulator"),
		EXTREMEITEMACCUMULATOR("item_extreme_item_accumulator"),

		// Food
		ENDERFRUIT("item_quartz_fruit");

		private String registryName;

		Items(String registryName) {
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}

	public static enum Blocks {
		DULLENDERBLOCK("block_dull_quartz_block"), ENDERBLOCK("block_quartz_block"),
		EMPOWEREDENDERBLOCK("block_empowered_quartz_block"), EXTREMEENDERBLOCK("block_extreme_quartz_block"),
		ENDERPEDESTAL("block_quartz_pedestal");

		private String registryName;

		Blocks(String registryName) {
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}

	public static enum Entities {
		ENDERPEDESTAL("entity_quartz_pedestal");

		private String registryName;

		Entities(String registryName) {
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
		ENDERGYCAPABILITY("capability_quartz_energy");

		private String registryName;

		Capabilities(String registryName) {
			this.registryName = registryName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}
}
