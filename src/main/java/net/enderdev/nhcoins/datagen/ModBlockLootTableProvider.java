package net.enderdev.nhcoins.datagen;

import net.enderdev.nhcoins.blocks.ModBlocks;
import net.enderdev.nhcoins.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        add(
                ModBlocks.VOIDORE, LootTable.lootTable().withPool(
                        applyExplosionCondition(
                                ModItems.VOID_SHARDS,
                                LootPool.lootPool()
                                .setRolls(new UniformGenerator(new ConstantValue(1), new ConstantValue(3)))
                                .add(LootItem.lootTableItem(ModItems.VOID_SHARDS))
                        )
                )
        );

//        dropWhenSilkTouch(ModBlocks.VOIDORE);
    }
}
