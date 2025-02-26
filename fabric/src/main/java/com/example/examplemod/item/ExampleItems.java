package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ExampleItems {
    public static final Item CUSTOM_STONE = registerItem("custom_stone", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.example_mod.custom_stone.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID, name), item);
    }

    public static void registerModItem(){

    }
}
