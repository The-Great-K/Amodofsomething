package thegreatk.somethingmod;

import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.util.UUID;

import javax.annotation.Nullable;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod.EventBusSubscriber
public class Config {

	private static boolean run = true;

	public static final String CATEGORY_GENERAL = "general";
	public static final String CATEGORY_FURNACE = "furnaces";
	public static final String CATEGORY_JEI = "jei";
	public static final String CATEGORY_UPDATES = "updates";
	public static final String CATEGORY_MISC = "misc";

	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;

	public static ForgeConfigSpec.IntValue furnaceXPDropValue;
	public static ForgeConfigSpec.IntValue furnaceXPDropValue2;

	public static ForgeConfigSpec.IntValue metalAlloyerSpeed;

	public static ForgeConfigSpec.IntValue metalAlloyerGeneration;

	public static ForgeConfigSpec.IntValue furnaceEnergyCapacityTier0;
	public static ForgeConfigSpec.IntValue furnaceEnergyCapacityTier1;
	public static ForgeConfigSpec.IntValue furnaceEnergyCapacityTier2;

	public static ForgeConfigSpec.IntValue metalAlloyerTier;

	public static ForgeConfigSpec.BooleanValue enableJeiPlugin;
	public static ForgeConfigSpec.BooleanValue enableJeiCatalysts;
	public static ForgeConfigSpec.BooleanValue enableJeiClickArea;

	public static ForgeConfigSpec.BooleanValue checkUpdates;

	public static ForgeConfigSpec.BooleanValue enableRainbowContent;

	public static ForgeConfigSpec.BooleanValue showErrors;

	// CACHE
	public static ForgeConfigSpec.IntValue cache_capacity;

	static {
		ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
		ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

		CLIENT_BUILDER.comment("Settings").push(CATEGORY_GENERAL);
		CLIENT_BUILDER.pop();

		CLIENT_BUILDER.comment("Furnace Settings").push(CATEGORY_FURNACE);

		setupFurnacesConfig(COMMON_BUILDER, CLIENT_BUILDER);
		setupGenerationConfig(COMMON_BUILDER, CLIENT_BUILDER);

		CLIENT_BUILDER.pop();

		CLIENT_BUILDER.pop();

		CLIENT_BUILDER.comment("JEI Settings").push(CATEGORY_JEI);

		setupJEIConfig(COMMON_BUILDER, CLIENT_BUILDER);

		CLIENT_BUILDER.pop();

		CLIENT_BUILDER.comment("Misc").push(CATEGORY_MISC);

		enableRainbowContent = CLIENT_BUILDER.comment(" Enable or disable the Rainbow Content").define("misc.rainbow",
				true);

		showErrors = CLIENT_BUILDER.comment(" Show furnace settings errors in chat, used for debugging")
				.define("misc.errors", false);

		CLIENT_BUILDER.pop();

		CLIENT_BUILDER.comment("Update Checker Settings").push(CATEGORY_UPDATES);

		setupUpdatesConfig(COMMON_BUILDER, CLIENT_BUILDER);

		CLIENT_BUILDER.pop();

		COMMON_CONFIG = COMMON_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}

	private static void setupGenerationConfig(ForgeConfigSpec.Builder COMMON_BUILDER,
			ForgeConfigSpec.Builder CLIENT_BUILDER) {
		metalAlloyerGeneration = CLIENT_BUILDER.comment(" How much RF to generate per tick\n Default: 20")
				.defineInRange("iron_furnace.generation", 20, 1, 100000);

	}

	private static void setupFurnacesConfig(ForgeConfigSpec.Builder COMMON_BUILDER,
			ForgeConfigSpec.Builder CLIENT_BUILDER) {

		furnaceEnergyCapacityTier0 = CLIENT_BUILDER
				.comment(" How much energy can be stored in tier 0 furnaces.\n Default: 80 000")
				.defineInRange("energy.tier_0", 80000, 4000, Integer.MAX_VALUE);

		furnaceEnergyCapacityTier1 = CLIENT_BUILDER
				.comment(" How much energy can be stored in tier 1 furnaces.\n Default: 200 000")
				.defineInRange("energy.tier_1", 200000, 4000, Integer.MAX_VALUE);

		furnaceEnergyCapacityTier2 = CLIENT_BUILDER
				.comment(" How much energy can be stored in tier 2 furnaces.\n Default: 1 000 000")
				.defineInRange("energy.tier_2", 1000000, 4000, Integer.MAX_VALUE);

		metalAlloyerTier = CLIENT_BUILDER.comment(" What tier this furnace should be.\n Default: 0")
				.defineInRange("iron_furnace.tier", 0, 0, 2);

		cache_capacity = CLIENT_BUILDER
				.comment(" The capacity of the recipe cache, higher values use more memory.\n Default: 10")
				.defineInRange("recipe_cache", 10, 1, 100);

		metalAlloyerSpeed = CLIENT_BUILDER.comment(
				" Number of ticks to complete one smelting operation.\n 200 ticks is what a regular furnace takes.\n Default: 160")
				.defineInRange("iron_furnace.speed", 160, 2, 72000);

		furnaceXPDropValue = CLIENT_BUILDER.comment(
				" This value indicates when the furnace should 'overload' and spit out the xp stored. \n Default: 10, Recipes")
				.defineInRange("furance_xp_drop.value", 10, 1, 500);

		furnaceXPDropValue2 = CLIENT_BUILDER.comment(
				" This value indicates when the furnace should 'overload' and spit out the xp stored. \n Default: 100000, Single recipe uses")
				.defineInRange("furance_xp_drop.value_two", 100000, 1, 1000000);

	}

	private static void setupJEIConfig(ForgeConfigSpec.Builder COMMON_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {

		enableJeiPlugin = CLIENT_BUILDER.comment(" Enable or disable the JeiPlugin of Mod of Something.")
				.define("jei.enable_jei", true);

		enableJeiCatalysts = CLIENT_BUILDER.comment(" Enable or disable the Catalysts in Jei for Mod of Something.")
				.define("jei.enable_jei_catalysts", true);

		enableJeiClickArea = CLIENT_BUILDER
				.comment(" Enable or disable the Click Area inside the GUI in all of Mod of Something' furnaces.")
				.define("jei.enable_jei_click_area", true);

	}

	private static void setupUpdatesConfig(ForgeConfigSpec.Builder COMMON_BUILDER,
			ForgeConfigSpec.Builder CLIENT_BUILDER) {

		checkUpdates = CLIENT_BUILDER
				.comment(" true = check for updates, false = don't check for updates.\n Default: true.")
				.define("check_updates.updates", true);

	}

	public static void loadConfig(ForgeConfigSpec spec, Path path) {
		ModOfSomething.LOGGER.debug("Loading config file {}", path);

		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave()
				.writingMode(WritingMode.REPLACE).build();

		ModOfSomething.LOGGER.debug("Built TOML config for {}", path.toString());
		configData.load();
		ModOfSomething.LOGGER.debug("Loaded TOML config file {}", path.toString());
		spec.setConfig(configData);
	}

	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {

	}

	@SubscribeEvent
	public static void onReload(final ModConfigEvent.Reloading configEvent) {

	}

	@SubscribeEvent
	public static void onWorldLoad(final WorldEvent.Load event) {
		Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("somethingmod-client.toml"));
		Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("somethingmod.toml"));
		run = true;

	}

	@SubscribeEvent
	public static void player(final TickEvent.PlayerTickEvent event) {

		if (!run) {
			return;
		}
		if (!event.player.getLevel().isClientSide) {
			if (event.player.getServer().getAdvancements() != null) {
				Advancement adv = event.player.getServer().getAdvancements()
						.getAdvancement(new ResourceLocation(ModOfSomething.MODID, "coal"));
			}

		}
		run = false;

	}

	@Nullable
	public static Player getPlayer(Level world) {
		if (world == null) {
			return null;
		}
		try {
			URL newestURL = new URL("https://raw.githubusercontent.com/Qelifern/IronFurnaces/"
					+ ModOfSomething.GITHUB_BRANCH + "/update/uuids.json");
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader(newestURL.openStream()));
			JsonObject rootobj = root.getAsJsonObject();
			JsonArray array = rootobj.get("values").getAsJsonArray();
			for (int i = 0; i < array.size(); i++) {
				if (world.getPlayerByUUID(UUID.fromString(array.get(i).getAsString())) != null) {
					return world.getPlayerByUUID(UUID.fromString(array.get(i).getAsString()));
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return null;
	}

}