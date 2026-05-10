package net.enderdev.nhcoins.datagen;

import net.enderdev.nhcoins.blocks.ModBlocks;
import net.enderdev.nhcoins.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jspecify.annotations.NonNull;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
	public void generateBlockStateModels(@NonNull BlockModelGenerators blockStateModelGenerator) {
		blockStateModelGenerator.createTrivialCube(ModBlocks.VOIDORE);
	}

	@Override
	public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerator) {
		itemModelGenerator.generateFlatItem(ModItems.GOLD_MOHUR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BRONZE_SICKLES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SILVER_DUCATS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.VOID_SHARDS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.VOIDCORE_INGOT, ModelTemplates.FLAT_ITEM);
	}

	@Override
	public String getName() {
		return "NHCoins Model Provider";
	}
}
