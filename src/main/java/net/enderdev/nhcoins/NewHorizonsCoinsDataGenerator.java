package net.enderdev.nhcoins;

import net.enderdev.nhcoins.datagen.*;
import net.enderdev.nhcoins.datagen.ModWorldgenProvider;
import net.enderdev.nhcoins.worldgen.ModWorldConfiguredFeatures;
import net.enderdev.nhcoins.worldgen.ModWorldPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class NewHorizonsCoinsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModTranslationProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModTagProvider::new);
		pack.addProvider(ModWorldgenProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModWorldConfiguredFeatures::configure);
		registryBuilder.add(Registries.PLACED_FEATURE, ModWorldPlacedFeatures::configure);
	}
}
