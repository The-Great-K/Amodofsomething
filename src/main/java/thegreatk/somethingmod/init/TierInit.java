package thegreatk.somethingmod.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.helpers.CreateArmorMaterial;
import thegreatk.somethingmod.helpers.CreateTier;

public final class TierInit {

	private TierInit() {
	}

	public static final Tier SILVER = new CreateTier(129, 0, 1, 18, 2,
			() -> Ingredient.of(ItemInit.SILVER_INGOT.get()));

	public static final ArmorMaterial SILVER_ARMOR = new CreateArmorMaterial(21, new int[] { 136, 192, 187, 148 },
			new int[] { 2, 5, 4, 2 }, 0.0F, 0.0F, ModOfSomething.MODID + ":silver", SoundEvents.MUSIC_DISC_WARD,
			() -> Ingredient.of(ItemInit.SILVER_INGOT.get()));

}
