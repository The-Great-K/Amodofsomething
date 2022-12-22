package thegreatk.somethingmod.helpers;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class ModStats extends Stats {

	public static final ResourceLocation INTERACT_WITH_METAL_ALLOYER = makeCustomStat("interact_with_metal_alloyer",
			StatFormatter.DEFAULT);

	private static ResourceLocation makeCustomStat(String name, StatFormatter formatter) {
		ResourceLocation resourcelocation = new ResourceLocation(name);
		Registry.register(Registry.CUSTOM_STAT, name, resourcelocation);
		CUSTOM.get(resourcelocation, formatter);
		return resourcelocation;
	}

}
