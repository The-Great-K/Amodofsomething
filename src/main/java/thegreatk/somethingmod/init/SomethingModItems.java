package thegreatk.somethingmod.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.CodakidFiles.Codakid;
import thegreatk.somethingmod.items.silver.SilverSwordItem;

public class SomethingModItems
{
	
	//Silver
	public static final RegistryObject<Item> SILVER_SWORD = Codakid.REGISTER_ITEMS.register("silver_sword", () -> new SilverSwordItem());
	
}
