package net.enderdev.nhcoins.datagen;

import net.enderdev.nhcoins.blocks.ModBlocks;
import net.enderdev.nhcoins.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModTranslationProvider extends FabricLanguageProvider {
    public ModTranslationProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.GOLD_MOHUR, "Mohur");
        translationBuilder.add(ModItems.SILVER_DUCATS, "Ducats");
        translationBuilder.add(ModItems.BRONZE_SICKLES, "Sickles");
        translationBuilder.add(ModItems.NHCOINS_ITEM_GROUP_KEY, "New Horizons Coins");
        translationBuilder.add(ModItems.METRO_TICKET, "Metro Ticket");
        translationBuilder.add(ModItems.VOID_SHARDS, "Void Shards");
        translationBuilder.add(ModItems.VOIDCORE_INGOT, "Void Core Ingot");

        translationBuilder.add(ModBlocks.COIN_SMITH, "Coin Smith");
        translationBuilder.add(ModBlocks.VOIDORE, "Void Ore");
//        translationBuilder.add(ModBlocks.ATM_BLOCK, "ATM Block");
//        translationBuilder.add("container.coin_smith", "Coin Smith");
    }
}
