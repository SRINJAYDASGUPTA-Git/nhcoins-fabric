package net.enderdev.nhcoins.recipe;

import net.enderdev.nhcoins.NewHorizonsCoins;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {
    public static final RecipeSerializer<CoinSmithRecipe> COIN_SMITH_RECIPE_SERIALIZER = Registry.register(
					BuiltInRegistries.RECIPE_SERIALIZER,
					Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, "coin_smithing"),
					new RecipeSerializer<>(CoinSmithRecipe.CODEC, CoinSmithRecipe.STREAM_CODEC)
	);

	public static final RecipeType<CoinSmithRecipe> COIN_SMITH_RECIPE_TYPE = Registry.register(
					BuiltInRegistries.RECIPE_TYPE,
					Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, "coin_smithing"),
					new RecipeType<CoinSmithRecipe>() { }
	);

	//:::registration

	// TODO - recipe book support, requires enum extensions + screen changes
	public static final RecipeBookCategory UPGRADING_RECIPE_BOOK_CATEGORY = Registry.register(
					BuiltInRegistries.RECIPE_BOOK_CATEGORY,
					Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, "upgrading"),
					new RecipeBookCategory()
	);
}
