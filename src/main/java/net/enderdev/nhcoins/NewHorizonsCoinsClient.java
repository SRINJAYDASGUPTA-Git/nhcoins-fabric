package net.enderdev.nhcoins;

import net.enderdev.nhcoins.rendering.screens.inventory.CoinSmithScreen;
import net.enderdev.nhcoins.screens.menu.ModMenus;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class NewHorizonsCoinsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenus.COIN_SMITH_MENU, CoinSmithScreen::new);
    }
}
