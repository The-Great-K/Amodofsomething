package thegreatk.somethingmod.CodakidFiles;

import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.init.BlockInit;
import thegreatk.somethingmod.init.ItemInit;

public class Codakid {

	/**
	 * Creates a Setup for a Block to be Registered
	 * 
	 * @param <T>
	 * @param name
	 * @param block
	 * @return
	 */
	public static <T extends Block> RegistryObject<T> registerBlockSetup(final String name,
			final Supplier<? extends T> block) {
		return BlockInit.BLOCKS.register(name, block);
	}

	/**
	 * Defines and Registers the Block Item Declared and Creates a Block for use
	 * 
	 * @param <T>
	 * @param name
	 * @param block
	 * @param item
	 * @return
	 */
	public static <T extends Block> RegistryObject<T> registerBlock(final String name,
			final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		RegistryObject<T> obj = registerBlockSetup(name, block);
		ItemInit.ITEMS.register(name, item.apply(obj));
		return obj;
	}

}
