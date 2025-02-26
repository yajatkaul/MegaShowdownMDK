package com.example.examplemod.creativeTab;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.ExampleItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final Supplier<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TAB.register("example_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ExampleItems.CUSTOM_STONE.get())) //Tab icon item
                    .title(Component.translatable("creativeTab.example_mod.example_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ExampleItems.CUSTOM_STONE);

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
