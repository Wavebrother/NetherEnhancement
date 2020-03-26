package wavebrother.netherenhancement.common.util;

import net.minecraft.data.loot.BlockLootTables;
import wavebrother.netherenhancement.common.init.ModBlocks;
import wavebrother.netherenhancement.common.init.ModItems;

public class OreLootTable extends BlockLootTables {

	@Override
	protected void addTables() {
		super.addTables();
		this.registerLootTable(ModBlocks.empoweredQuartzOre, (block) -> {
			return BlockLootTables.droppingItemWithFortune(block, ModItems.empoweredQuartz);
		});
		this.registerLootTable(ModBlocks.extremeQuartzOre, (block) -> {
			return BlockLootTables.droppingItemWithFortune(block, ModItems.extremeQuartz);
		});
	}
}
