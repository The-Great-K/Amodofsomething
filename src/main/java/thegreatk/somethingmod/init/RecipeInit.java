package thegreatk.somethingmod.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import thegreatk.somethingmod.recipe.AlloyerRecipe;

public interface RecipeInit<T extends Recipe<?>> extends RecipeType<T> {

	RecipeInit<AlloyerRecipe> ALLOYER = register("alloyer");

	static <T extends Recipe<?>> RecipeInit<T> register(final String recipe) {
		return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(recipe), new RecipeInit<T>() {
			public String toString() {
				return recipe;
			}
		});
	}
}