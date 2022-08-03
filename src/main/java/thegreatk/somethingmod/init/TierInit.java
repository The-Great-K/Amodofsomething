package thegreatk.somethingmod.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import thegreatk.somethingmod.helpers.CreateTier;

public final class TierInit {
	
	public static final Tier SILVER = new CreateTier(2, 129, 0, 4, 18, () -> Ingredient.of(ItemInit.SILVER_INGOT.get()));

}
