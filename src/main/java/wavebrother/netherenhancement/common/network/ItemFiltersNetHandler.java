package wavebrother.netherenhancement.common.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import wavebrother.netherenhancement.Reference;

/**
 * @author LatvianModder
 */
public class ItemFiltersNetHandler
{
	public static SimpleChannel NET;

	public static void init()
	{
		NET = NetworkRegistry.newSimpleChannel(
				new ResourceLocation(Reference.MOD_ID, "channel"),
				() -> "1.0.1",
				s -> s.startsWith("1"),
				s -> s.startsWith("1")
		);

		NET.registerMessage(1, MessageUpdateFilterItem.class, MessageUpdateFilterItem::write, MessageUpdateFilterItem::new, MessageUpdateFilterItem::handle);
	}
}