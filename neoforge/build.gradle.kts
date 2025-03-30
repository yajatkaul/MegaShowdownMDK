plugins {
    id("java")
    id("dev.architectury.loom") version("1.7-SNAPSHOT")
    id("architectury-plugin") version("3.4-SNAPSHOT")
    kotlin("jvm") version "1.9.23"
}


group = "org.example"
version = "1.0-SNAPSHOT"

architectury {
    platformSetupLoomIde()
    neoForge()
}

loom {
    silentMojangMappingsLicense()
}

repositories {
    mavenCentral()
    maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
    maven("https://maven.impactdev.net/repository/development/")
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://thedarkcolour.github.io/KotlinForForge/")
    maven("https://maven.neoforged.net")

    maven {
        name = "Modrinth"
        url = uri("https://api.modrinth.com/maven")
    }

    maven {
        name = "Illusive Soulworks maven"
        url = uri("https://maven.theillusivec4.top/")
    }
}

dependencies {
    minecraft("net.minecraft:minecraft:1.21.1")
    mappings(loom.officialMojangMappings())
    neoForge("net.neoforged:neoforge:21.1.66")

    modImplementation("com.cobblemon:neoforge:1.6.0+1.21.1-SNAPSHOT")
    modImplementation("maven.modrinth:cobblemon-mega-showdown:8.2.0-release-neoforge")
    //Needed for cobblemon
    implementation("thedarkcolour:kotlinforforge-neoforge:5.3.0") {
        exclude("net.neoforged.fancymodloader", "loader")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    // Compile against only the API artifact
    compileOnly("top.theillusivec4.curios:curios-neoforge:${properties["curios_version"]}:api")

    // Use the full Curios API jar at runtime
    runtimeOnly("top.theillusivec4.curios:curios-neoforge:${properties["curios_version"]}")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("META-INF/neoforge.mods.toml") {
        expand(project.properties)
    }
}