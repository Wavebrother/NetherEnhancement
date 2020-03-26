package wavebrother.netherenhancement.common.util;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

/**
 * @author LatvianModder
 */
public class FilterInfoImpl implements FilterInfo
{
	private final List<ITextComponent> list;
	private String indent = "";

	public FilterInfoImpl(List<ITextComponent> l)
	{
		list = l;
	}

	@Override
	public void add(ITextComponent component)
	{
		list.add(new StringTextComponent(indent + "- ").applyTextStyle(TextFormatting.YELLOW).appendSibling(component.applyTextStyle(TextFormatting.GRAY)));
	}

	@Override
	public void push()
	{
		indent += "  ";
	}

	@Override
	public void pop()
	{
		indent = indent.substring(2);
	}
}