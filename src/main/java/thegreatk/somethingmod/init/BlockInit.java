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
import thegreatk.somethingmod.furnacetest.MetalAlloyerBlock;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ModOfSomething.MODID);

	private BlockInit() {
	}

	// MACHINES
	public static final RegistryObject<Block> METAL_ALLOYER = Codakid.registerBlock("metal_alloyer",
			() -> new MetalAlloyerBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY)
					.strength(4.0F).sound(SoundType.ANVIL).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	// NATURAL METALS
	// Silver
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

	// Tin
	public static final RegistryObject<Block> TIN_ORE = Codakid.registerBlock("tin_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)
					.strength(3.0F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Block> RAW_TIN_BLOCK = Codakid.registerBlock("raw_tin_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)
					.strength(5.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Block> TIN_BLOCK = Codakid.registerBlock("tin_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE)
					.strength(4.5F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	// Titanium
	public static final RegistryObject<Block> TITANIUM_ORE = Codakid.registerBlock("titanium_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
					.strength(3.0F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Block> RAW_TITANIUM_BLOCK = Codakid.registerBlock("raw_titanium_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Block> TITANIUM_BLOCK = Codakid.registerBlock("titanium_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY)
					.strength(4.5F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	// ALLOYED METALS
	// Electrum
	public static final RegistryObject<Block> ELECTRUM_BLOCK = Codakid.registerBlock("electrum_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW)
					.strength(4.5F, 6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

}
