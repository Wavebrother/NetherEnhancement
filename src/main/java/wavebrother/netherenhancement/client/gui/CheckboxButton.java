package wavebrother.netherenhancement.client.gui;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import wavebrother.netherenhancement.Reference;

public class CheckboxButton extends AbstractButton {
	   private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/checkbox.png");
	   boolean isPressed;

	public CheckboxButton(int xIn, int yIn, int widthIn, int heightIn, String msg, boolean isPressed) {
		super(xIn, yIn, widthIn, heightIn, msg);
		this.isPressed = isPressed;
		// TODO Auto-generated constructor stub
	}

	   public void onPress() {
	      this.isPressed = !this.isPressed;
	   }

	   public boolean isPressed() {
	      return this.isPressed;
	   }

	   public void renderButton(int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_) {
	      Minecraft minecraft = Minecraft.getInstance();
	      minecraft.getTextureManager().bindTexture(texture);
	      GlStateManager.enableDepthTest();
	      FontRenderer fontrenderer = minecraft.fontRenderer;
	      GlStateManager.color4f(1.0F, 1.0F, 1.0F, this.alpha);
	      GlStateManager.enableBlend();
	      GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
	      GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
	      blit(this.x, this.y, 0.0F, this.isPressed ? 20.0F : 0.0F, 20, this.height, 32, 64);
	      this.renderBg(minecraft, p_renderButton_1_, p_renderButton_2_);
	      int i = 14737632;
	      this.drawString(fontrenderer, this.getMessage(), this.x + 24, this.y + (this.height - 8) / 2, 14737632 | MathHelper.ceil(this.alpha * 255.0F) << 24);
	   }
}
