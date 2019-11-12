package wavebrother.netherenhancement.common.item.tool;

import java.util.HashSet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.item.IQuartzItem;
import wavebrother.netherenhancement.common.util.NetherTier;

@EventBusSubscriber(bus = Bus.MOD, modid = Reference.MOD_ID)
public class EnderMultiTool extends ToolItem implements IQuartzItem {

	private static final EnderToolsUtil tool = EnderToolsUtil.TOOL;

	static {
		MinecraftForge.EVENT_BUS.register(EnderMultiTool.class);
	}

	public EnderMultiTool(NetherTier material, String name) {
		super(tool.getDamage(material), tool.getSpeed(material), material.toolTier, new HashSet<Block>(),
				new Item.Properties().group(NetherEnhancement.CREATIVE_TAB)
						.addToolType(ToolType.AXE, material.toolTier.getHarvestLevel())
						.addToolType(ToolType.PICKAXE, material.toolTier.getHarvestLevel())
						.addToolType(ToolType.SHOVEL, material.toolTier.getHarvestLevel()));
		setRegistryName(name);
		this.tier = material;
		// TODO Auto-generated constructor stub
	}

	private final NetherTier tier;

	@Override
	public NetherTier getEnderTier() {
		return tier;
	}

	@SubscribeEvent
	public static void onHarvestBlock(HarvestDropsEvent event) {
		NetherEnhancement.getLogger().debug("Harvest");
		if (!event.getWorld().isRemote() && event.isCancelable()) {
			for (ItemStack drop : event.getDrops())
				if (!event.getHarvester().addItemStackToInventory(drop)) {
					Block.spawnAsEntity((World) event.getWorld(), event.getPos(), drop);
				}
			event.setCanceled(true);
		}
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		return efficiency;
	}

	public boolean canHarvestBlock(BlockState blockIn) {
		@SuppressWarnings("unused")
		Block block = blockIn.getBlock();
		int i = this.getTier().getHarvestLevel();
		if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
			return i >= blockIn.getHarvestLevel();
		}
		Material material = blockIn.getMaterial();
		return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL
				|| material == Material.DRAGON_EGG || material == Material.SHULKER;
	}
}
