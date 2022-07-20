package thegreatk.somethingmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import thegreatk.somethingmod.CodakidFiles.Codakid;
import thegreatk.somethingmod.blocks.silver.SilverOre;
import thegreatk.somethingmod.items.silver.SilverSword;

@Mod(ModOfSomething.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModOfSomething
{
    public static final String MODID = "somethingmod";
    public static final String MODNAME = "A Mod Of Something";
    public static String VERSION = "0.0.1";
    
    public static ModOfSomething instance;
    
    public static Tier SILVER;
    public static final SilverOre SILVER_ORE = new SilverOre();
    public static final SilverSword SILVER_SWORD = new SilverSword();

    
    public ModOfSomething()
    {
        
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
    	//****************** INITIALIZE BLOCKS *****************

    	
    	//****************** REGISTER BLOCKS *****************
    	//Silver
    	Codakid.registerBlock(SILVER_ORE, "silver_ore");
    	
    	
    	
        Codakid.doBlockRegistry(event);
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
    	//****************** INITIALIZE ITEMS *****************
    	
    	//****************** REGISTER TIERS *****************
    	SILVER = Codakid.addTier(1, 129, 10, 4F, 18);
    	
    	//****************** REGISTER ITEMS *****************
    	//Silver
    	Codakid.registerItem(SILVER_SWORD, "silver_sword");
    	
    	
    	
    	Codakid.doItemRegistry(event); 
    }
}