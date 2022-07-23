package thegreatk.somethingmod.CodakidFiles;

import java.util.ArrayList;
import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;

public class Codakid
{
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModOfSomething.MODID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModOfSomething.MODID);
	
    public static ArrayList<Block> blocksToRegister = new ArrayList<>();
    public static ArrayList<Item> itemsToRegister = new ArrayList<>();
    
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return  toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ITEMS.register(name, () -> new BlockItem(block.get(),
            new Item.Properties().tab(tab)));
    }
    
    public static void registerBlock(IEventBus eventBus)
    {
    	BLOCKS.register(eventBus);
    }

    
    public static void registerItem(IEventBus eventBus)
    {
    	ITEMS.register(eventBus);
    }

    public static void doBlockRegistry(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(blocksToRegister.toArray(new Block[blocksToRegister.size()]));
    }
    
    public static void doItemRegistry(RegistryEvent.Register<Item> event) 
    {
        event.getRegistry().registerAll(itemsToRegister.toArray(new Item[itemsToRegister.size()]));
    }

    public static Tier addTier(int miningLevel, int maxUses, float miningSpeed, float damageBonus, int enchantability)
    {

        return new Tier() {
            @Override
            public int getUses() {return maxUses;}

            @Override
            public float getSpeed() {return miningSpeed;}

            @Override
            public float getAttackDamageBonus() {return damageBonus;}

            @Override
            public int getLevel() {return miningLevel;}

            @Override
            public int getEnchantmentValue() {return enchantability;}

            @Override
            public Ingredient getRepairIngredient() {return null;}
        };
    }

}
