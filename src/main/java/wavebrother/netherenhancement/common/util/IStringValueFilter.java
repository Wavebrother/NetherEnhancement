package wavebrother.netherenhancement.common.util;

import java.util.Collection;
import java.util.Collections;

import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author LatvianModder
 */
public interface IStringValueFilter extends IItemFilter
{
	String getValue(ItemStack filter);

	void setValue(ItemStack filter, String v);

	@OnlyIn(Dist.CLIENT)
	default Collection<StringValueFilterVariant> getValueVariants(ItemStack stack)
	{
		return Collections.emptyList();
	}
}