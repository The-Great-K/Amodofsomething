package thegreatk.somethingmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

public class AbstractMetalAlloyerBlockEntity extends AbstractFurnaceBlockEntity {

	protected AbstractMetalAlloyerBlockEntity(RegistryObject<BlockEntityType> type, BlockPos pos, BlockState state,
			RecipeType<? extends AbstractCookingRecipe> recipeType) {
		super(type, pos, state, recipeType);
	}

	@Override
	protected Component getDefaultName() {
		return new TranslatableComponent("container.metal_alloyer");
	}

	@Override
	protected AbstractContainerMenu createMenu(int num, Inventory inventory) {
		return new FurnaceMenu(num, inventory, this, this.dataAccess);
	}

}
