package thegreatk.somethingmod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import thegreatk.somethingmod.init.BlockInit;
import thegreatk.somethingmod.init.ItemInit;

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
    	
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        
        MinecraftForge.EVENT_BUS.register(this);
        
    }
    
    public static final CreativeModeTab SOMETHING_MOD_TAB = new CreativeModeTab(MODID)
    {
		@Override
		public ItemStack makeIcon() 
		{
			return new ItemStack(BlockInit.SILVER_ORE.get());
		}	
	};
	
}