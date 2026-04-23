# Cobblemon: Mega Showdown — MDK

> **Mod Development Kit** for [Cobblemon: Mega Showdown](https://github.com/yajatkaul/CobblemonMegaShowdown) — the battle overhaul that adds Mega Evolutions, Z-Moves, Terastalization, and Pokémon Fusions to Cobblemon.

Use this MDK to build add-on mods that integrate custom Mega Stones and Mega Evolutions into Mega Showdown, for both **NeoForge** and **Fabric** (including a multiloader Architectury template).

📖 **Full documentation:** [Mega Showdown Wiki](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki)

---

## Project Structure

The MDK offers three templates depending on your target platform:

```
MegaShowdownMDK/
├── multiloader/        # Architectury-based multiloader (Fabric + NeoForge)
│   ├── common/         # Shared code
│   ├── fabric/         # Fabric-specific entrypoint
│   └── neoforge/       # NeoForge-specific entrypoint
├── fabric/             # Standalone Fabric-only template
└── neoforge/           # Standalone NeoForge-only template
```

Pick the template that matches your workflow. The standalone templates are simpler — no Architectury API required.

---

## Prerequisites

- JDK 21+
- Git
- Basic knowledge of Minecraft mod development (Fabric or NeoForge)

---

## Getting Started

```bash
git clone https://github.com/yajatkaul/MegaShowdownMDK.git
cd MegaShowdownMDK
```

Open the folder for your chosen template in your IDE and run the Gradle setup.

---

## Plugins

Each template requires a specific set of Gradle plugins.

**Multiloader** — root `build.gradle`
```groovy
plugins {
    id 'dev.architectury.loom' version '1.13-SNAPSHOT' apply false
    id 'architectury-plugin' version '3.4-SNAPSHOT'
    id 'com.github.johnrengelman.shadow' version '8.1.1' apply false
    id 'org.jetbrains.kotlin.jvm' version '2.2.10'
}

architectury {
    minecraft = project.minecraft_version
}

allprojects {
    group = rootProject.maven_group
    version = rootProject.mod_version
}

subprojects {
    apply plugin: 'dev.architectury.loom'
    apply plugin: 'architectury-plugin'
    apply plugin: 'maven-publish'
    apply plugin: 'org.jetbrains.kotlin.jvm'
}
```

**Fabric-only**
```groovy
plugins {
    id 'fabric-loom' version '1.11-SNAPSHOT'
    id 'maven-publish'
    id 'org.jetbrains.kotlin.jvm' version '2.2.10'
}
```

**NeoForge-only**
```groovy
plugins {
    id 'java-library'
    id 'maven-publish'
    id 'idea'
    id 'net.neoforged.moddev' version '2.0.140'
    id 'org.jetbrains.kotlin.jvm' version '2.2.10'
}
```

---

## Dependencies

### Multiloader Template (Architectury)

The multiloader template shares common code via the `common` subproject and splits platform-specific code into `fabric` and `neoforge` subprojects.

**`common/`**
| Dependency | Purpose |
|---|---|
| `net.fabricmc:fabric-loader` | Fabric environment annotations (do **not** use other Fabric Loader classes here) |
| `dev.architectury:architectury` | Architectury common API |
| `io.wispforest:accessories-common` | Accessories API (compile-only) |
| `com.cobblemon:mod` | Cobblemon (compile-only) |
| `maven.modrinth:cobblemon-mega-showdown` | Mega Showdown (compile-only) |

**`fabric/`**
| Dependency | Purpose |
|---|---|
| `net.fabricmc:fabric-loader` | Fabric Loader |
| `net.fabricmc.fabric-api:fabric-api` | Fabric API |
| `dev.architectury:architectury-fabric` | Architectury Fabric runtime |
| `net.fabricmc:fabric-language-kotlin` | Kotlin support for Fabric |
| `io.wispforest:accessories-fabric` | Accessories API (Fabric) |
| `com.cobblemon:fabric` | Cobblemon (Fabric) |
| `maven.modrinth:cobblemon-mega-showdown` | Mega Showdown (Fabric) |

**`neoforge/`**
| Dependency | Purpose |
|---|---|
| `net.neoforged:neoforge` | NeoForge |
| `dev.architectury:architectury-neoforge` | Architectury NeoForge runtime |
| `thedarkcolour:kotlinforforge-neoforge` | Kotlin support for NeoForge |
| `io.wispforest:accessories-neoforge` | Accessories API (NeoForge) |
| `com.cobblemon:neoforge` | Cobblemon (NeoForge) |
| `maven.modrinth:cobblemon-mega-showdown` | Mega Showdown (NeoForge) |

---

### Standalone Templates (Fabric-only / NeoForge-only)

These templates drop Architectury and are simpler to work with if you only target one platform.

**Fabric-only**
| Dependency | Purpose |
|---|---|
| `net.fabricmc:fabric-loader` | Fabric Loader |
| `net.fabricmc.fabric-api:fabric-api` | Fabric API |
| `net.fabricmc:fabric-language-kotlin` | Kotlin support |
| `io.wispforest:accessories-fabric` | Accessories API |
| `com.cobblemon:fabric` | Cobblemon |
| `maven.modrinth:cobblemon-mega-showdown` | Mega Showdown |

**NeoForge-only**
| Dependency | Purpose |
|---|---|
| `thedarkcolour:kotlinforforge-neoforge` | Kotlin support |
| `io.wispforest:accessories-neoforge` | Accessories API |
| `com.cobblemon:neoforge` | Cobblemon |
| `maven.modrinth:cobblemon-mega-showdown` | Mega Showdown |

---

## Repositories

The following repositories are required in your `build.gradle` / `settings.gradle`:

```groovy
maven { url "https://maven.fabricmc.net/" }           // Fabric only
maven { url "https://maven.architectury.dev/" }        // Multiloader only
maven { url "https://maven.neoforged.net/releases" }   // NeoForge only
maven { url "https://maven.wispforest.io" }            // Accessories / Endec
maven { url "https://maven.cobblemon.com/releases" }   // Cobblemon
maven { url "https://api.modrinth.com/maven" }         // Mega Showdown
```

---

## Notes

- **Mappings (Fabric):** Prefer **Yarn mappings** on the Fabric templates. Using Mojang mappings on Fabric can cause issues due to mapping conflicts with Cobblemon and other dependencies that expect Yarn-mapped names at runtime.
- **Multiloader common module:** Do not use Fabric Loader classes in `common/` beyond the `@Environment` annotations — these won't remap correctly on NeoForge.
- **NeoForge runtime libraries:** The multiloader NeoForge subproject pulls in several `forgeRuntimeLibrary` dependencies (Jankson, Endec modules) that are already bundled in Mega Showdown itself — you generally don't need to shadow these into your own jar.

---

## Documentation

All documentation is available on the [CobblemonMegaShowdown Wiki](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki).

| Page | Description |
|---|---|
| [Custom Form Changes](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki/Custom-Form-Changes) | Defining when and how Pokémon forms change and revert |
| [Custom Gimmicks](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki/Custom-Gimmicks) | Creating custom battle gimmicks (e.g. Mega Evolution, Z-Moves) |
| [Custom Persistent Statuses](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki/Custom-Persistent-Statuses) | Adding custom statuses that persist across turns |
| [Custom Showdown Datapacking](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki/Custom-Showdown-Datapacking) | Writing Showdown-side battle logic via datapacks |
| [Custom Showdown Item](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki/Custom-Showdown-Item) | Registering custom held items on the Showdown side |
| [Custom Types](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki/Custom-Types) | Adding new Pokémon types |
| [Datapack Item's Usage](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki/Datapack-Item's-Usage) | How datapack-defined items are used in-game |
| [Miscellaneous](https://github.com/yajatkaul/CobblemonMegaShowdown/wiki/Miscellaneous) | Universal form change conditions and other utilities |

---

## Related

- [Cobblemon: Mega Showdown](https://github.com/yajatkaul/CobblemonMegaShowdown) — the main mod this MDK targets
- [Accessories](https://github.com/wisp-forest/accessories) — required accessory slot API
- [Architectury API](https://github.com/architectury/architectury-api) — multiloader abstraction layer (multiloader template only)
