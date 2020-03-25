package wavebrother.netherenhancement.common.util;

import net.minecraft.util.text.ITextComponent;

/**
 * @author LatvianModder
 */
public interface FilterInfo
{
	void add(ITextComponent component);

	void push();

	void pop();
}