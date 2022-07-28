package thegreatk.somethingmod.CodakidFiles;

import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;

public class Codakid
{
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModOfSomething.MODID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModOfSomething.MODID);
	
	public static <T extends Item> RegistryObject<T> registerItem(final String name, final Supplier<T> item)
	{
		return ITEMS.register(name, item);
	}
	
	public static <T extends Block> RegistryObject<T> registerBlockSetup(final String name,
			final Supplier<? extends T> block) 
	{
		return BLOCKS.register(name, block);
	}

	public static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block,
		Function<RegistryObject<T>, Supplier<? extends Item>> item) 
	{
		RegistryObject<T> obj = registerBlockSetup(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}

}
