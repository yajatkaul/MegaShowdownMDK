package com.example.examplemod.creativeTab;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.ExampleItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeModeTabs {
    public static final ItemGroup MEGA_SHOWDOWN_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ExampleMod.MOD_ID, "example_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ExampleItems.CUSTOM_STONE)) // Creative TAB icon
                    .displayName(Text.translatable("creativeTab.example_mod.example_tab"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ExampleItems.CUSTOM_STONE);
                    }))
                    .build());

    public static void registerItemGroups(){

    }
}
