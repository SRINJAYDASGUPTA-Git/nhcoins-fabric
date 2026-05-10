package net.enderdev.nhcoins;

import net.enderdev.nhcoins.blocks.ModBlocks;
import net.enderdev.nhcoins.item.ModItems;
import net.enderdev.nhcoins.recipe.ModRecipes;
import net.enderdev.nhcoins.screens.menu.ModMenus;
import net.enderdev.nhcoins.villager.ModVillagers;
import net.enderdev.nhcoins.worldgen.ModWorldPlacedFeatures;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewHorizonsCoins implements ModInitializer {
	public static final String MOD_ID = "nhcoins";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		BiomeModifications.addFeature(
				BiomeSelectors.foundInTheEnd(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ModWorldPlacedFeatures.VOIDORE_PLACED_KEY
		);

		ModItems.registerModItems();
		ModBlocks.initialize();
		ModVillagers.registerVillagers();
		ModMenus.initialize();
		RecipeSynchronization.synchronizeRecipeSerializer(ModRecipes.COIN_SMITH_RECIPE_SERIALIZER);
	}
}