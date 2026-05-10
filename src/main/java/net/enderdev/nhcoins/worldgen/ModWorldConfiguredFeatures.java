package net.enderdev.nhcoins.worldgen;

import net.enderdev.nhcoins.NewHorizonsCoins;
import net.enderdev.nhcoins.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class ModWorldConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOIDORE_VEIN_CONFIGURED_KEY =
			ResourceKey.create(
				Registries.CONFIGURED_FEATURE,
				Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, "voidore_vein")
			);

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplaceableRule = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> voidOreConfig =
                List.of(
                        OreConfiguration.target(deepslateReplaceableRule, ModBlocks.VOIDORE.defaultBlockState())
                );

        context.register(
                VOIDORE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(voidOreConfig, 5)) // 10 is the blocks per vein
        );
    }


}
