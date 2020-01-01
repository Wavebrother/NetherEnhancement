package wavebrother.netherenhancement.client.renderer;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import wavebrother.netherenhancement.common.item.ItemVoid;
import wavebrother.netherenhancement.common.item.PigmanAgitator;
import wavebrother.netherenhancement.common.tiles.QuartzPedestalTileEntity;

@SuppressWarnings("deprecation")
public class QuartzPedestalTER extends TileEntityRenderer<QuartzPedestalTileEntity> {
	public QuartzPedestalTER() {
	}

	@Override
	public void render(QuartzPedestalTileEntity te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		ItemStack itemstack = te.getPedestalItem();
		if (itemstack != null && itemstack != ItemStack.EMPTY) {
			GlStateManager.pushMatrix();
			GlStateManager.translatef((float) x + 0.5F, (float) y + 1, (float) z + 0.5F);
			if (checkRotation(itemstack)) {
				float rotation = (float) (getWorld().getGameTime() % 160);
				GlStateManager.rotatef(360f * rotation / 160f, 0, 1, 0);
			}
			Minecraft.getInstance().getItemRenderer().renderItem(itemstack, ItemCameraTransforms.TransformType.FIXED);
			GlStateManager.popMatrix();
		}

	}

	private boolean checkRotation(ItemStack item) {
		if (item.getItem() instanceof PigmanAgitator) {
			return true;
		}
		if (item.getItem() instanceof ItemVoid) {
			return item.hasTag() && item.getTag().contains(ItemVoid.voidTag)
					&& item.getTag().getBoolean(ItemVoid.voidTag);
		}
		return false;
	}
}