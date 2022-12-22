package thegreatk.somethingmod.recipe;

import com.google.gson.JsonObject;

import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.extensions.IForgeRecipeSerializer;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface ModRecipeSerializer<T extends Recipe<?>>
		extends IForgeRegistryEntry<RecipeSerializer<?>>, IForgeRecipeSerializer<T>, RecipeSerializer<T> {
	AlloyerCookingSerializer<AlloyerRecipe> ALLOYER_RECIPE = register("alloyer",
			new AlloyerCookingSerializer<>(AlloyerRecipe::new, 100));

	// Forge: use fromJson with IContext if you need the context
	T fromJson(ResourceLocation p_44103_, JsonObject p_44104_);

	@javax.annotation.Nullable
	T fromNetwork(ResourceLocation p_44105_, FriendlyByteBuf p_44106_);

	void toNetwork(FriendlyByteBuf p_44101_, T p_44102_);

	static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String p_44099_, S p_44100_) {
		return Registry.register(Registry.RECIPE_SERIALIZER, p_44099_, p_44100_);
	}
}
