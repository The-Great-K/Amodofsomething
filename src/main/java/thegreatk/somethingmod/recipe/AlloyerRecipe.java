package thegreatk.somethingmod.recipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import thegreatk.somethingmod.init.BlockInit;
import thegreatk.somethingmod.init.RecipeInit;

public class AlloyerRecipe extends AbstractAlloyerRecipe {

	public AlloyerRecipe(ResourceLocation id, String group, Ingredient ingredient, Ingredient ingredient2,
			ItemStack result, float experience, int cookingTime) {
		super(RecipeInit.ALLOYER, id, group, ingredient, ingredient2, result, experience, cookingTime);
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(BlockInit.METAL_ALLOYER.get());
	}

	public RecipeSerializer<?> getSerializer() {
		return ModRecipeSerializer.ALLOYER_RECIPE;
	}
}