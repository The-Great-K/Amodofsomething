package thegreatk.somethingmod.CodakidFiles;

import java.util.ArrayList;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;

public class Codakid {

    public static ArrayList<Block> blocksToRegister = new ArrayList<>();
    public static ArrayList<Item> itemsToRegister = new ArrayList<>();
    
    public static void registerBlock(Block block, String registryName) {
        block.setRegistryName(registryName);
        ItemNameBlockItem itemBlock = new ItemNameBlockItem(block, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
        itemBlock.setRegistryName(registryName);
        blocksToRegister.add(block);
        itemsToRegister.add(itemBlock);
    }

    public static void registerItem(Item item, String registryName) {
        item.setRegistryName(registryName);
        itemsToRegister.add(item);
    }

    public static void doBlockRegistry(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(blocksToRegister.toArray(new Block[blocksToRegister.size()]));
    }
    
    public static void doItemRegistry(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(itemsToRegister.toArray(new Item[itemsToRegister.size()]));
    }

    public static Tier addTier(int miningLevel, int maxUses, float miningSpeed, float damageBonus, int enchantability){

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
