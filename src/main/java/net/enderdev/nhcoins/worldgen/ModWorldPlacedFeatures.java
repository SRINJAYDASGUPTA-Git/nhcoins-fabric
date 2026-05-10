package net.enderdev.nhcoins.worldgen;

import net.enderdev.nhcoins.NewHorizonsCoins;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModWorldPlacedFeatures {
    public static final ResourceKey<PlacedFeature> VOIDORE_PLACED_KEY =
			ResourceKey.create(
				Registries.PLACED_FEATURE,
				Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, "voidore_placed")
			);

    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> voidOreVeinModifiers = List.of(
				CountPlacement.of(3),
					BiomeFilter.biome(),
					InSquarePlacement.spread(),
				HeightRangePlacement.of(BiasedToBottomHeight.of(VerticalAnchor.aboveBottom(32), VerticalAnchor.absolute(50), 3))
		);

        context.register(
				VOIDORE_PLACED_KEY,
				new PlacedFeature(
					configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.VOIDORE_VEIN_CONFIGURED_KEY),
					voidOreVeinModifiers
				)
		);
    }
}
