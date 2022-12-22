package thegreatk.somethingmod.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class AlloyerCookingSerializer<T extends AbstractAlloyerRecipe> extends ForgeRegistryEntry<RecipeSerializer<?>>
		implements ModRecipeSerializer<T> {
	private final int defaultCookingTime;
	private final AlloyerCookingSerializer.CookieBaker<T> factory;

	public AlloyerCookingSerializer(AlloyerCookingSerializer.CookieBaker<T> factory, int defaultCookingTime) {
		this.factory = factory;
		this.defaultCookingTime = defaultCookingTime;
	}

	public T fromJson(ResourceLocation location, JsonObject object) {
		String s = GsonHelper.getAsString(object, "group");
		// Ingredients
		JsonElement jsonelement = (JsonElement) (GsonHelper.isArrayNode(object, "ingredient")
				? GsonHelper.getAsJsonArray(object, "ingredient")
				: GsonHelper.getAsJsonObject(object, "ingredient"));
		Ingredient ingredient = Ingredient.fromJson(jsonelement);
		// Ingredient 2
		JsonElement jsonelement2 = (JsonElement) (GsonHelper.isArrayNode(object, "ingredient2")
				? GsonHelper.getAsJsonArray(object, "ingredient2")
				: GsonHelper.getAsJsonObject(object, "ingredient2"));
		Ingredient ingredient2 = Ingredient.fromJson(jsonelement2);
		// Forge: Check if primitive string to keep vanilla or a object which can
		// contain a count field.

		// Result
		if (!object.has("result"))
			throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
		ItemStack itemstack;
		if (object.get("result").isJsonObject())
			itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(object, "result"));
		else {
			String s1 = GsonHelper.getAsString(object, "result");
			ResourceLocation resourcelocation = new ResourceLocation(s1);
			itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
				return new IllegalStateException("Item: " + s1 + " does not exist");
			}));
		}
		// Experience
		float experience = GsonHelper.getAsFloat(object, "experience", 0.0F);
		// Cooking Time
		int defaultCookingTime = GsonHelper.getAsInt(object, "cookingtime", this.defaultCookingTime);
		// Creates Recipe
		return this.factory.create(location, s, ingredient, ingredient2, itemstack, experience, defaultCookingTime);
	}

	public T fromNetwork(ResourceLocation location, FriendlyByteBuf byteBuf) {
		String s = byteBuf.readUtf();
		Ingredient ingredient = Ingredient.fromNetwork(byteBuf);
		Ingredient ingredient2 = Ingredient.fromNetwork(byteBuf);
		ItemStack itemstack = byteBuf.readItem();
		float experience = byteBuf.readFloat();
		int defaultCookingTime = byteBuf.readVarInt();
		return this.factory.create(location, s, ingredient, ingredient2, itemstack, experience, defaultCookingTime);
	}

	public void toNetwork(FriendlyByteBuf byteBuf, T object) {
		byteBuf.writeUtf(object.group);
		object.ingredient.toNetwork(byteBuf);
		object.ingredient2.toNetwork(byteBuf);
		byteBuf.writeItem(object.result);
		byteBuf.writeFloat(object.experience);
		byteBuf.writeVarInt(object.cookingTime);
	}

	interface CookieBaker<T extends AbstractAlloyerRecipe> {
		T create(ResourceLocation location, String s, Ingredient ingredient, Ingredient ingredient2,
				ItemStack itemstack, float experience, int defaultCookingTime);
	}
}
