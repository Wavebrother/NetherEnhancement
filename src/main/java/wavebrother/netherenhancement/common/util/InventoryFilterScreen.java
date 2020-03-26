package wavebrother.netherenhancement.common.util;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import wavebrother.netherenhancement.Reference;
import wavebrother.netherenhancement.common.containers.InventoryFilterContainer;
import wavebrother.netherenhancement.common.item.ItemVoid;

public class InventoryFilterScreen extends ContainerScreen<InventoryFilterContainer>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/filter.png");

	public InventoryFilterScreen(InventoryFilterContainer container, PlayerInventory playerInventory, ITextComponent title)
	{
		super(container, playerInventory, title);
		xSize = 176;
		ySize = 166;
		addButton(container.inventory.filterItem.autoDelete);
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		for(Widget widget: buttons)
			widget.render(mouseX, mouseY, partialTicks);
		renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color4f(1F, 1F, 1F, 1F);
		minecraft.getTextureManager().bindTexture(TEXTURE);
		blit(guiLeft, guiTop, 0, 0, xSize, ySize);

		for (ItemVoid.FilterSlot slot : container.filterSlots)
		{
			blit(guiLeft + slot.x - 1, guiTop + slot.y - 1, 177, 0, 18, 18);
		}
		
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color4f(1F, 1F, 1F, 1F);
		font.drawString(getTitle().getFormattedText(), 8, 6, 4210752);
		font.drawString(Minecraft.getInstance().player.inventory.getDisplayName().getFormattedText() + " Filter", 8, 72, 4210752);
	}
} 