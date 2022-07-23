package thegreatk.somethingmod.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.CodakidFiles.Codakid;

public class SomethingModBlocks
{
	
	//Silver
    public static final RegistryObject<Block> SILVER_ORE = Codakid.registerBlock("silver_ore",
    	() -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModOfSomething.SOMETHING_MOD_TAB);
	
}
