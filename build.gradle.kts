plugins {
    val kotlinVersion = "1.4.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.0-M1"
}

group = "net.mamoe"
version = "0.2.0"

mirai {
    publishing {
        repo = "mirai"
        packageName = "chat-command"
        override = true
    }
}

repositories {
    mavenLocal()
    jcenter()
}

kotlin.sourceSets.forEach { it.languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn") }

tasks.create("buildCiJar", Jar::class) {
    dependsOn("buildPlugin")
    doLast {
        val buildPluginTask = tasks.getByName("buildPlugin", Jar::class)
        val buildPluginFile = buildPluginTask.archiveFile.get().asFile
        project.buildDir.resolve("ci").also {
            it.mkdirs()
        }.resolve("chat-command.jar").let {
            buildPluginFile.copyTo(it, true)
        }
    }
}
