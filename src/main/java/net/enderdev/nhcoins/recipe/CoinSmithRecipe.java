package net.enderdev.nhcoins.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.codec.ByteBufCodecs;
import org.jspecify.annotations.Nullable;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

// :::baseClass
public class CoinSmithRecipe implements Recipe<CoinSmithRecipeInput> {
    private final ItemStackTemplate result;
    private final Ingredient input;

    public CoinSmithRecipe(ItemStackTemplate result, Ingredient input) {
        this.input = input;
        this.result = result;
    }

    public ItemStackTemplate getResult() {
        return result;
    }

    public Ingredient getInput() {
        return input;
    }


    // ✅ MATCHES (single input)
    @Override
    public boolean matches(CoinSmithRecipeInput recipeInput, Level level) {
        return input.test(recipeInput.input());
    }

    // ✅ OUTPUT (single operation, scaling happens in menu)
    @Override
    public ItemStack assemble(CoinSmithRecipeInput recipeInput) {
        return result.create().copy();
    }

    // registry stuff stays same
    @Override
    public RecipeSerializer<? extends Recipe<CoinSmithRecipeInput>> getSerializer() {
        return ModRecipes.COIN_SMITH_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<CoinSmithRecipeInput>> getType() {
        return ModRecipes.COIN_SMITH_RECIPE_TYPE;
    }

    // recipe book (unchanged)
    @Override
    public @Nullable RecipeBookCategory recipeBookCategory() {
        return null;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "coin_smithing";
    }
    // :::recipeBook

    //:::mapCodec
    public static final MapCodec<CoinSmithRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(CoinSmithRecipe::getResult),
                    Ingredient.CODEC.fieldOf("input").forGetter(CoinSmithRecipe::getInput)
            ).apply(instance, CoinSmithRecipe::new)
    );
    //:::mapCodec

    //:::streamCodec
    public static final StreamCodec<RegistryFriendlyByteBuf, CoinSmithRecipe> STREAM_CODEC = StreamCodec.composite(
            ItemStackTemplate.STREAM_CODEC,
            CoinSmithRecipe::getResult,
            Ingredient.CONTENTS_STREAM_CODEC,
            CoinSmithRecipe::getInput,
            CoinSmithRecipe::new
    );
    //:::streamCodec

    // :::baseClass
}