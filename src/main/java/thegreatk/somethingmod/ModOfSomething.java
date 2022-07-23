package thegreatk.somethingmod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
    
    //****************** DECLARE TIERS *****************
    public static Tier SILVER;
    
    public ModOfSomething()
    {
    	
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        Codakid.ITEMS.register(eventBus);
        Codakid.BLOCKS.register(eventBus);
        
    }
    
    public static final CreativeModeTab SOMETHING_MOD_TAB = new CreativeModeTab(MODID)
    {
		
		@Override
		public ItemStack makeIcon() 
		{
			return Items.BLACKSTONE.getDefaultInstance();
		}
	};
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {	
    	//****************** INITIALIZE TIERS *****************
    	SILVER = Codakid.addTier(1, 129, 10, 4F, 18);
    }
}