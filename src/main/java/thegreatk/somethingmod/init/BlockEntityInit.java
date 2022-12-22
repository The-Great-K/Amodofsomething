package thegreatk.somethingmod.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.block.entity.MetalAlloyerBlockEntity;

public class BlockEntityInit {

	private BlockEntityInit() {
	}

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, ModOfSomething.MODID);

	public static final RegistryObject<BlockEntityType<MetalAlloyerBlockEntity>> METAL_ALLOYER_BLOCK_ENTITY = BLOCK_ENTITIES
			.register("metal_alloyer_block_entity", () -> BlockEntityType.Builder
					.of(MetalAlloyerBlockEntity::new, BlockInit.METAL_ALLOYER.get()).build(null));

}
