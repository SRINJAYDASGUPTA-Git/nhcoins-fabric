package net.enderdev.nhcoins.villager;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.enderdev.nhcoins.NewHorizonsCoins;
import net.enderdev.nhcoins.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Block;

public class ModVillagers {


    public static final ResourceKey<PoiType> BANKER_POI_KEY = registerPoIKey("banker_poi");
    public static final PoiType BANKER_POI = registerPOI("banker_poi", ModBlocks.COIN_SMITH);

    public static final VillagerProfession BANKER = registerProfession("banker", BANKER_POI_KEY);
    public static final ResourceKey<TradeSet> BANKER_LEVEL_1 = registerTradeSetKey("banker/level_1");
    private static VillagerProfession registerProfession(String name, ResourceKey<PoiType> type){

        return Registry.register(
                BuiltInRegistries.VILLAGER_PROFESSION,
                Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, name),
                new VillagerProfession(
                        Component.translatable(name),
                        poiTypeHolder -> poiTypeHolder.is(type),
                        poiTypeHolder -> poiTypeHolder.is(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN, Int2ObjectMap.ofEntries(Int2ObjectMap.entry(1, BANKER_LEVEL_1))));
    }

    private static ResourceKey<TradeSet> registerTradeSetKey(String name){
        return ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, name));
    }
    private static PoiType registerPOI(String name, Block block){
        return PoiHelper.register(
                Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, name),
                1, 1, block
        );
    }

    private static ResourceKey<PoiType> registerPoIKey(String name){
        return ResourceKey.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE.key(), Identifier.fromNamespaceAndPath(NewHorizonsCoins.MOD_ID, name));

    }

    public static void registerVillagers() {
        NewHorizonsCoins.LOGGER.info("Registering villagers for "+NewHorizonsCoins.MOD_ID);

    }
}
