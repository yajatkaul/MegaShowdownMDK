# Cobblemon: Mega Showdown - Neoforge & Fabric MDK

This guide provides instructions for modders who wish to add their own custom Mega Evolutions in Cobblemon: Mega Showdown using Neoforge and Fabric. Follow the steps below to integrate new Mega Stones and assign them to specific Pokémon species.

---

## Neoforge

### 1. Assigning a Mega Stone to a Pokémon

To register a custom Mega Stone and associate it with a specific Pokémon species, add the following code inside the `onServerStarting` event:

**File Path:** `/neoforge/src/main/com/example/examplemod/ExampleMod.java`

```java
@SubscribeEvent
public void onServerStarting(ServerStartingEvent event) {
    Utils.MEGA_STONE_IDS.put(ExampleItems.CUSTOM_STONE.asItem(), getSpecies("groudon"));
}
```

### 2. Creating a Custom Mega Stone

Modify the following file:

**File Path:** `/neoforge/src/main/com/example/examplemod/item/ExampleItems.java`

```java
public static final DeferredItem<Item> CUSTOM_STONE = ITEMS.register("custom_stone",
        () -> new Item(new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.example_mod.custom_stone.tooltip"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });
```

### 3. Adding the Custom Mega Stone to a Creative Tab

Modify the following file:

**File Path:** `/neoforge/src/main/com/example/examplemod/creativeTab/ModCreativeModeTabs.java`

```java
public static final Supplier<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TAB.register("example_tab",
        () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(ExampleItems.CUSTOM_STONE.get())) //Tab icon item
                .title(Component.translatable("creativeTab.example_mod.example_tab"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ExampleItems.CUSTOM_STONE);
                })
                .build());
```

---

## Fabric

### 1. Assigning a Mega Stone to a Pokémon

To register a custom Mega Stone and associate it with a specific Pokémon species, modify:

**File Path:** `/fabric/src/main/java/com/example/examplemod/ExampleMod.java`

```java
private void onServerStarted(MinecraftServer server) {
    Utils.MEGA_STONE_IDS.put(ExampleItems.CUSTOM_STONE.asItem(), getSpecies("groudon"));
}
```

### 2. Creating a Custom Mega Stone

Modify the following file:

**File Path:** `/fabric/src/main/java/com/example/examplemod/item/ExampleItems.java`

```java
public static final Item CUSTOM_STONE = registerItem("custom_stone", new Item(new Item.Settings()) {
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.example_mod.custom_stone.tooltip"));
        super.appendTooltip(stack, context, tooltip, type);
    }
});
```

### 3. Adding the Custom Mega Stone to a Creative Tab

Modify the following file:

**File Path:** `/fabric/src/main/java/com/example/examplemod/creativeTab/ModCreativeModeTabs.java`

```java
public static final ItemGroup MEGA_SHOWDOWN_TAB = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(ExampleMod.MOD_ID, "example_tab"),
        FabricItemGroup.builder().icon(() -> new ItemStack(ExampleItems.CUSTOM_STONE)) // Creative TAB icon
                .displayName(Text.translatable("creativeTab.example_mod.example_tab"))
                .entries(((displayContext, entries) -> {
                    entries.add(ExampleItems.CUSTOM_STONE);
                }))
                .build());
```

### Explanation:

- `entries.add(ExampleItems.CUSTOM_STONE);` adds the custom Mega Stone to the creative tab.
- `FabricItemGroup.builder().icon(() -> new ItemStack(ExampleItems.CUSTOM_STONE))` sets the tab icon to the custom Mega Stone (can be changed if needed).
- `Text.translatable("creativeTab.example_mod.example_tab")` allows localization for the tab name.

---

This covers the basics of adding custom Mega Stones in both Neoforge and Fabric. The next section will cover the data pack side of the integration.
