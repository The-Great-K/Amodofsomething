package thegreatk.somethingmod.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.CodakidFiles.Codakid;

public class BlockInit
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModOfSomething.MODID);
	
	private BlockInit() {}
	
	//Silver
	public static final RegistryObject<Block> SILVER_ORE = Codakid.registerBlock("silver_ore",
		() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)
			.strength(3.0F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()),
		object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));
	
	public static final RegistryObject<Block> RAW_SILVER_BLOCK = Codakid.registerBlock("raw_silver_block", 
		() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)
			.strength(5.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()),
		object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));
	
	public static final RegistryObject<Block> SILVER_BLOCK = Codakid.registerBlock("silver_block",
		() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE)
			.strength(4.5F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()),
		object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));
	
}
