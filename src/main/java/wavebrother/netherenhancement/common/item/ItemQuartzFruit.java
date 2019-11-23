package wavebrother.netherenhancement.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import wavebrother.netherenhancement.NetherEnhancement;
import wavebrother.netherenhancement.Reference;

public class ItemQuartzFruit extends Item {

	public static final String TOOLTIP = "Mmmm. Crunchy.";

	public static int hunger = 16;
	public static float saturation = 1.0F;

	public ItemQuartzFruit() {
		super(new Properties().group(NetherEnhancement.CREATIVE_TAB).food(createFruit()));
		setRegistryName(Reference.Items.QUARTZFRUIT.getRegistryName());
	}

	private static Food createFruit() {
		Food.Builder foodBuilder = new Food.Builder().hunger(hunger).saturation(saturation)
				.effect(new EffectInstance(Effects.REGENERATION, 600), 1)
				.effect(new EffectInstance(Effects.SPEED, 600), 1)
				.effect(new EffectInstance(Effects.NIGHT_VISION, 1200), 1)
				.effect(new EffectInstance(Effects.STRENGTH, 600), 1);
		return foodBuilder.build();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent(TOOLTIP));
	}
	// protected void onFoodEaten(ItemStack stack, World World, EntityPlayer Player)
	// {
	// if (!World.isRemote)
	// {
	// Player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 0));
	// Player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600, 0));
	// Player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200, 0));
	// Player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 0));
	// Player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 3600, 0));
	// Player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 600, 0));
	// Player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 600, 0));
	// Player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 600, 0));

	// }
	// }

}
