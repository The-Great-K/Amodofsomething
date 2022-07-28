package thegreatk.somethingmod.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.CodakidFiles.Codakid;

public final class SomethingModItems
{
	
	private SomethingModItems() {}
	
	//Items
	
	//Silver
	public static final RegistryObject<Item> RAW_SILVER = Codakid.registerItem("raw_silver",
		() -> new Item(new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));
	
	public static final RegistryObject<Item> SILVER_INGOT = Codakid.registerItem("silver_ingot",
		() -> new Item(new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));
	
	public static final RegistryObject<SwordItem> SILVER_SWORD = Codakid.registerItem("silver_sword",
		() -> new SwordItem(SomethingModTiers.SILVER, 0, -2.4F,
			new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));
	
}
