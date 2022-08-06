package thegreatk.somethingmod.helpers;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreWorldGen {

	public static final List<ConfiguredFeature<OreConfiguration, OreFeature>> OVERWORLD_ORES = new ArrayList<>();
	public static final List<ConfiguredFeature<OreConfiguration, OreFeature>> NETHER_ORES = new ArrayList<>();
	public static final List<ConfiguredFeature<OreConfiguration, OreFeature>> END_ORES = new ArrayList<>();

	public static void generate(final BiomeLoadingEvent event) {

	}

}
