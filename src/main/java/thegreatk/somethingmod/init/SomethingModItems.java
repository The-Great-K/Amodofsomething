package thegreatk.somethingmod.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.CodakidFiles.Codakid;

public final class SomethingModItems
{
	
	private SomethingModItems() {}
	
	//Silver
	public static final RegistryObject<SwordItem> SILVER_SWORD = Codakid.ITEMS.register("silver_sword",
		() -> new SwordItem(ModOfSomething.SILVER, 0, -1.6F,
			new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));
	
}
