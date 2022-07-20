package thegreatk.somethingmod.CodakidFiles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import thegreatk.somethingmod.helpers.OreWorldGen;
import net.minecraft.data.worldgen.placement.PlacementUtils;

public class OreHelper 
{
	public static Holder<PlacedFeature> OVERWORLD_SILVER_GEN;
	
    public static void spawnBlock(Level level, BlockPos pos, Block block, int count) 
    {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();

        for(int i = 0; i < count; i++)
            level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(block)));
    }

    public static void registerWorldGen()
    {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreWorldGen::generate);
    }

    public static void sivlerOreGeneration(final BiomeLoadingEvent event, RuleTest rule, BlockState state, String registryName, int veinSize, int minHeight, int maxHeight, int amount) 
    {
    	OreConfiguration overworldSilverConfig = new OreConfiguration(rule, state, veinSize);
        OVERWORLD_SILVER_GEN = registerPlacedOreFeature(registryName, new ConfiguredFeature<>(Feature.ORE, overworldSilverConfig),
            	CountPlacement.of(amount),
            	InSquarePlacement.spread(),
            	BiomeFilter.biome(),
            	HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))
        );
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
        } else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
        } else {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OVERWORLD_SILVER_GEN);
        }
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedOreFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }
}
