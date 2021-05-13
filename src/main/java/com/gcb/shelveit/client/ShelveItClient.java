package com.gcb.shelveit.client;

import com.gcb.shelveit.ShelveIt;
import com.gcb.shelveit.screenhandlers.BookShelfScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ShelveItClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ShelveIt.BOOKSHELF_SCREEN_HANDLER, BookShelfScreen::new);
    }
}


