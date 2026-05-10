package net.enderdev.nhcoins.item;

import net.enderdev.nhcoins.NewHorizonsCoins;
import net.enderdev.nhcoins.blocks.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ModItems {
     public static final Item GOLD_MOHUR = register(
             "gold_mohur",
             Item::new,
             new Item.Properties()
                     .rarity(Rarity.UNCOMMON)
                     .stacksTo(64)
     );
     public static final Item SILVER_DUCATS = register(
             "silver_ducats",
             Item::new,
             new Item.Properties()
                     .rarity(Rarity.UNCOMMON)
                     .stacksTo(64)
     );
     public static final Item BRONZE_SICKLES = register(
             "bronze_sickles",
             Item::new,
             new Item.Properties()
                     .rarity(Rarity.UNCOMMON)
                     .stacksTo(64)
     );

     public static final Item METRO_TICKET = register(
             "metro_ticket",
             Item :: new,
             new Item.Properties()
                     .rarity(Rarity.UNCOMMON)
                     .stacksTo(64)
     );

     public static final Item VOID_SHARDS = register(
             "void_shards",
             Item::new,
             new Item.Properties()
                     .rarity(Rarity.EPIC)
                     .stacksTo(64)
     );

     public static final Item VOIDCORE_INGOT = register(
             "voidcore_ingot",
             Item::new,
             new Item.Properties().rarity(Rarity.EPIC).stacksTo(64)
     );

     public static final ResourceKey<CreativeModeTab> NHCOINS_ITEM_GROUP_KEY =
             ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                     Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, "item_group"));

    public static final CreativeModeTab NHCOINS_ITEM_GROUP = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(GOLD_MOHUR))
            .title(Component.translatable("itemGroup.nhcoins_tab"))
            .displayItems(((parameters, output) -> {
                output.accept(GOLD_MOHUR);
                output.accept(SILVER_DUCATS);
                output.accept(BRONZE_SICKLES);
                output.accept(METRO_TICKET);
                output.accept(VOID_SHARDS);
                output.accept(VOIDCORE_INGOT);

                output.accept(ModBlocks.COIN_SMITH);
                output.accept(ModBlocks.VOIDORE);
            }))
            .build();

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        NewHorizonsCoins.LOGGER.info("Registering Mod Items for " + NewHorizonsCoins.MOD_ID);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, NHCOINS_ITEM_GROUP_KEY, NHCOINS_ITEM_GROUP);

    }
}