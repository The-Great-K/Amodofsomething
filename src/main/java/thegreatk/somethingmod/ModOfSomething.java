package thegreatk.somethingmod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
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
    
    public ModOfSomething()
    {
    	
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        Codakid.ITEMS.register(eventBus);
        Codakid.BLOCKS.register(eventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
        
    }
    
    public static final CreativeModeTab SOMETHING_MOD_TAB = new CreativeModeTab(MODID)
    {
		
		@Override
		public ItemStack makeIcon() 
		{
			return new ItemStack(Items.BLACKSTONE);
		}
		
	};
	
}