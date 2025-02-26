package com.example.examplemod;

import com.cobblemon.yajatkaul.mega_showdown.utility.Utils;
import com.example.examplemod.creativeTab.ModCreativeModeTabs;
import com.example.examplemod.item.ExampleItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cobblemon.yajatkaul.mega_showdown.utility.Utils.getSpecies;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "example_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ExampleItems.registerModItem();
        ModCreativeModeTabs.registerItemGroups();

        ServerLifecycleEvents.SERVER_STARTED.register(this::onServerStarted);
    }

    private void onServerStarted(MinecraftServer server) {
        Utils.MEGA_STONE_IDS.put(ExampleItems.CUSTOM_STONE.asItem(), getSpecies("groudon"));
    }
}