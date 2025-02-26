# Adding Mega Evolutions for Existing Pokémon

This guide provides an example of how to add Mega Evolutions to existing Pokémon using Mega Metagross as a reference. The stripped version of Souls Mega Pack contains all necessary configurations to set up a Mega Evolution.

---

## 1. Dex Entry Additions

**File Path:** `data/cobblemon/dex_entry_additions/pokemon/hoenn/mega_metagross.json`

This file adds a dex entry for Mega Metagross. You should create a similar file for your custom Mega Pokémon.

---

## 2. Species Features

**File Path:** `data/cobblemon/species_features/mega.json`

This JSON defines the Mega Evolution feature. It includes details about how Mega Evolution functions in the game.

---

## 3. Assigning Mega Evolution to a Species

**File Path:** `data/cobblemon/species_feature_assignments/mega.json`

This file assigns the Mega Evolution feature to specific Pokémon species. Modify it to link your desired Pokémon to its Mega Evolution.

---

## 4. Animations and Models

**File Paths:**

- `assets/cobblemon/bedrock/animations/0376_metagross/metagross_mega.animation.json`
- `assets/cobblemon/bedrock/models/0376_metagross/metagross_mega.geo.json`
- `assets/cobblemon/bedrock/posers/0376_metagross/metagross_mega.json`

These files define the 3D model, animations, and poses for Mega Metagross. You need to create equivalent files for your own Mega Pokémon.

---

## 5. Species Data

**File Path:** `assets/cobblemon/bedrock/species/0376_metagross/1_metagross_mega.json`

This file contains the species data for Mega Metagross, including stats, abilities, and forms. Copy this structure when creating a Mega Evolution for another Pokémon.

---

## 6. Localization (Names and Descriptions)

**File Path:** `assets/cobblemon/lang/en_us.json`

This file contains localized names and descriptions for the Mega Pokémon. Update it to include the name and description of your Mega Evolution.

---

## 7. Mega Evolution Particle Effects

**File Paths:**

- `assets/cobblemon/particles/snowstorm.json`
- `assets/cobblemon/textures/particle/mega_icon.png`

These files control particle effects for Mega Evolution. Customize them if you want unique visual effects for your Mega Pokémon.

---

## How to Use This Reference

To add Mega Evolutions for another Pokémon, follow these steps:

1. Duplicate the files mentioned above and rename them for your Pokémon.
2. Modify the contents to match your Pokémon's ID, animations, and stats.
3. Add entries to `species_feature_assignments/mega.json` to link your Pokémon to Mega Evolution.
4. Ensure your animations, models, and species data files are correctly placed in the appropriate directories.

By following these steps, you can successfully create custom Mega Evolutions using the example of Mega Metagross as a guide.

### 📥 Download Example Files

[Download Example.zip](./Example.zip)
