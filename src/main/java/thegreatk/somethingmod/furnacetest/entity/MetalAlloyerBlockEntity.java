package thegreatk.somethingmod.furnacetest.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeConfigSpec;
import thegreatk.somethingmod.Config;
import thegreatk.somethingmod.init.BlockEntityInit;

public class MetalAlloyerBlockEntity extends MetalAlloyerBlockEntityBase {
	public MetalAlloyerBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.METAL_ALLOYER_BLOCK_ENTITY.get(), pos, state);
	}

	@Override
	public ForgeConfigSpec.IntValue getCookTimeConfig() {
		return Config.metalAlloyerSpeed;
	}

	@Override
	public String IgetName() {
		return "container.somethingmod.metal_alloyer";
	}

	@Override
	public AbstractContainerMenu IcreateMenu(int i, Inventory playerInventory, Player playerEntity) {
		return new MetalALloyerBlockContainer(i, level, worldPosition, playerInventory, playerEntity);
	}

	@Override
	public int getTier() {
		return Config.metalAlloyerTier.get();
	}

	@Override
	public Component getName() {
		return name;
	}

}