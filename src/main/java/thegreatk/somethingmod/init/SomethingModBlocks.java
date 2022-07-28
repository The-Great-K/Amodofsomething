package thegreatk.somethingmod.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.CodakidFiles.Codakid;

public class SomethingModBlocks
{
	
	//Silver
	public static final RegistryObject<Block> SILVER_ORE = Codakid.registerBlock("silver_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).strength(3.0f)
			.strength(3F).sound(SoundType.STONE).requiresCorrectToolForDrops()),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));
	
}
