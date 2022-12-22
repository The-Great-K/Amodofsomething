package thegreatk.somethingmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;
import thegreatk.somethingmod.init.BlockEntityInit;

public class MetalAlloyerBlockEntity extends AbstractMetalAlloyerBlockEntity {
	public MetalAlloyerBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.METAL_ALLOYER_BLOCK_ENTITY, pos, state, RecipeType.SMELTING);
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
