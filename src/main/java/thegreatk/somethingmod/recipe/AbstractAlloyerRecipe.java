package thegreatk.somethingmod.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public abstract class AbstractAlloyerRecipe implements Recipe<Container> {
	protected final RecipeType<?> type;
	protected final ResourceLocation id;
	protected final String group;
	protected final Ingredient ingredient;
	protected final Ingredient ingredient2;
	protected final ItemStack result;
	protected final float experience;
	protected final int cookingTime;

	public AbstractAlloyerRecipe(RecipeType<?> type, ResourceLocation id, String group, Ingredient ingredient,
			Ingredient ingredient2, ItemStack result, float experience, int cookingTime) {
		this.type = type;
		this.id = id;
		this.group = group;
		this.ingredient = ingredient;
		this.ingredient2 = ingredient2;
		this.result = result;
		this.experience = experience;
		this.cookingTime = cookingTime;
	}

	public boolean matches(Container container, Level level) {
		return this.ingredient.test(container.getItem(0));
	}

	public ItemStack assemble(Container container) {
		return this.result.copy();
	}

	public boolean canCraftInDimensions(int p_43743_, int p_43744_) {
		return true;
	}

	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> nonnulllist = NonNullList.create();
		nonnulllist.add(this.ingredient);
		nonnulllist.add(this.ingredient2);
		return nonnulllist;
	}

	public float getExperience() {
		return this.experience;
	}

	public ItemStack getResultItem() {
		return this.result;
	}

	public String getGroup() {
		return this.group;
	}

	public int getCookingTime() {
		return this.cookingTime;
	}

	public ResourceLocation getId() {
		return this.id;
	}

	public RecipeType<?> getType() {
		return this.type;
	}
}