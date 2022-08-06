package thegreatk.somethingmod.init;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import thegreatk.somethingmod.ModOfSomething;

public final class ItemInit {

	private ItemInit() {
	}

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ModOfSomething.MODID);

	// Silver
	public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
			() -> new Item(new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
			() -> new Item(new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
			() -> new Item(new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword",
			() -> new SwordItem(TierInit.SILVER, 3, -2.4F,
					new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe",
			() -> new PickaxeItem(TierInit.SILVER, 1, -2.8F,
					new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe",
			() -> new AxeItem(TierInit.SILVER, 6, -3.0F, new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel",
			() -> new ShovelItem(TierInit.SILVER, 1.5F, -3.0F,
					new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe",
			() -> new HoeItem(TierInit.SILVER, -1, -2.0F, new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet",
			() -> new ArmorItem(TierInit.SILVER_ARMOR, EquipmentSlot.HEAD,
					new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate",
			() -> new ArmorItem(TierInit.SILVER_ARMOR, EquipmentSlot.CHEST,
					new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register("silver_leggings",
			() -> new ArmorItem(TierInit.SILVER_ARMOR, EquipmentSlot.LEGS,
					new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

	public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register("silver_boots",
			() -> new ArmorItem(TierInit.SILVER_ARMOR, EquipmentSlot.FEET,
					new Item.Properties().tab(ModOfSomething.SOMETHING_MOD_TAB)));

}
