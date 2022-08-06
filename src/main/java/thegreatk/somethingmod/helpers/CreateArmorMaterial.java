package thegreatk.somethingmod.helpers;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class CreateArmorMaterial implements ArmorMaterial {

	private final float toughness, knockbackResistance;
	private final int enchantability;
	private final int[] defense, durability;
	private final Supplier<Ingredient> repairMaterial;
	private final SoundEvent sound;
	private final String name;

	public CreateArmorMaterial(int enchantability, int[] durability, int[] damageReduction, float knockbackResistance,
			float toughness, String name, SoundEvent equipSound, Supplier<Ingredient> repairMaterial) {
		this.enchantability = enchantability;
		this.durability = durability;
		this.defense = damageReduction;
		this.knockbackResistance = knockbackResistance;
		this.toughness = toughness;
		this.name = name;
		this.sound = equipSound;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot slot) {
		return this.durability[slot.getIndex()];
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot slot) {
		return this.defense[slot.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {

		return enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairMaterial.get();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getToughness() {
		return toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return knockbackResistance;
	}

}
