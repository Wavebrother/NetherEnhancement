package wavebrother.netherenhancement.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import wavebrother.netherenhancement.common.item.ItemVoid;
import wavebrother.netherenhancement.common.item.PigmanAgitator;
import wavebrother.netherenhancement.common.tiles.QuartzPedestalTileEntity;

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class QuartzPedestalTER extends TileEntityRenderer<QuartzPedestalTileEntity> {

	public QuartzPedestalTER(TileEntityRendererDispatcher disp) {
		super(disp);
	}

	public void func_225616_a_(QuartzPedestalTileEntity pedestal, float float1, MatrixStack matrix,
			IRenderTypeBuffer buffer, int int1, int int2) {
		ItemStack itemstack = pedestal.getPedestalItem();
		if (!itemstack.isEmpty()) {
			matrix.func_227860_a_();
			matrix.func_227861_a_(0.5D, 1.0D, 0.5D);
			if (doesRotation(itemstack)) {
				matrix.func_227863_a_(
						Vector3f.field_229179_b_.func_229187_a_((float) (pedestal.getWorld().getGameTime() % 360)));
				matrix.func_227863_a_(
						Vector3f.field_229181_d_.func_229187_a_((float) (pedestal.getWorld().getGameTime() % 360)));
			}
			Minecraft.getInstance().getItemRenderer().func_229110_a_(itemstack,
					ItemCameraTransforms.TransformType.FIXED, int1, OverlayTexture.field_229196_a_, matrix, buffer);
			matrix.func_227865_b_();
		}

	}

	private boolean doesRotation(ItemStack item) {
		if (item.getItem() instanceof PigmanAgitator) {
			return true;
		}
		if (item.getItem() instanceof ItemVoid) {
			return true;
//			return item.hasTag() && item.getTag().contains(ItemVoid.voidTag)
//					&& item.getTag().getBoolean(ItemVoid.voidTag);
		}
		return false;
	}
}