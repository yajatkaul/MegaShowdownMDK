package com.example.examplemod;

import com.cobblemon.yajatkaul.mega_showdown.utility.Utils;
import com.example.examplemod.creativeTab.ModCreativeModeTabs;
import com.example.examplemod.item.ExampleItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cobblemon.yajatkaul.mega_showdown.utility.Utils.getSpecies;

@Mod(ExampleMod.MOD_ID)
public class ExampleMod {
    public static final Logger LOGGER = LoggerFactory.getLogger("ExampleMod");
    public static final String MOD_ID = "example_mod";

    public ExampleMod(IEventBus modEventBus, @NotNull ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ExampleItems.register(modEventBus);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        Utils.MEGA_STONE_IDS.put(ExampleItems.CUSTOM_STONE.asItem(), getSpecies("groudon"));
    }
}
