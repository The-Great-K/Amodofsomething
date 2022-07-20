package thegreatk.somethingmod.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class SomethingModCreativeTab {
    public static final CreativeModeTab SOMETHING_MOD_TAB = new CreativeModeTab("something_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIRT);
            //SomethingModItems.(Later a melting furnace icon).get()
        }
    };
}