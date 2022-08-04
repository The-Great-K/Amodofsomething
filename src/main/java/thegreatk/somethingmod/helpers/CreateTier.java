package thegreatk.somethingmod.helpers;

import java.util.function.Supplier;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class CreateTier implements Tier 
{
	
	private final float attackDamageBonus, speed;
	private final int enchantibility, harvestLevel, durability;
	private final Supplier<Ingredient> repairMaterial;
	
	public CreateTier(int durability, float speed, float attackDamageBonus, int enchantability,
			int harvestLevel, Supplier<Ingredient> repairMaterial)
	{
		this.attackDamageBonus = attackDamageBonus;
		this.speed = speed;
		this.enchantibility = enchantability;
		this.harvestLevel = harvestLevel;
		this.durability = durability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getUses()
	{
		return durability;
	}

	@Override
	public float getSpeed() 
	{
		return speed;
	}

	@Override
	public float getAttackDamageBonus() 
	{
		return attackDamageBonus;
	}

	@Override
	public int getLevel() 
	{
		return harvestLevel;
	}

	@Override
	public int getEnchantmentValue() 
	{
		return enchantibility;
	}

	@Override
	public Ingredient getRepairIngredient() 
	{
		return this.repairMaterial.get();
	}

}
