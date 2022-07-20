package thegreatk.somethingmod.items.silver;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import thegreatk.somethingmod.ModOfSomething;

public class SilverSword extends SwordItem
{
	public SilverSword()
	{
		super(ModOfSomething.SILVER, 0, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}
}
