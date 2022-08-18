package thegreatk.somethingmod.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.block.entity.XpConverterBlockEntity;

public class BlockEntityInit {

	private BlockEntityInit() {
	}

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, ModOfSomething.MODID);

	public static final RegistryObject<BlockEntityType<XpConverterBlockEntity>> XP_CONVERTER = BLOCK_ENTITIES.register(
			"xp_converter",
			() -> BlockEntityType.Builder.of(XpConverterBlockEntity::new, BlockInit.XP_CONVERTER.get()).build(null));

}
