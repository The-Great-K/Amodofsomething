package thegreatk.somethingmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import thegreatk.somethingmod.CodakidFiles.Codakid;

@Mod(ModOfSomething.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModOfSomething
{
    public static final String MODID = "somethingmod";
    public static final String MODNAME = "A Mod Of Something";
    public static String VERSION = "0.0.1";
    
    public static ModOfSomething instance;
    
    public static Tier SILVER;

    
    public ModOfSomething()
    {
    	
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        Codakid.REGISTER_ITEMS.register(eventBus);
        Codakid.REGISTER_BLOCKS.register(eventBus);
        
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {	
    	//****************** INITIALIZE TIERS *****************
    	SILVER = Codakid.addTier(1, 129, 10, 4F, 18);
    }
}