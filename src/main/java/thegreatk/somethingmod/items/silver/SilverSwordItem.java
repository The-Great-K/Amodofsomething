package thegreatk.somethingmod.items.silver;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import thegreatk.somethingmod.ModOfSomething;

public class SilverSwordItem extends SwordItem
{
	public SilverSwordItem()
	{
		super(ModOfSomething.SILVER, 0, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}
}
