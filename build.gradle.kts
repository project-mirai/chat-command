plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"

    id("net.mamoe.mirai-console") version "2.13.4"
}

group = "net.mamoe"
version = "0.6.0"

mirai {
    publishing {
        repo = "mirai"
        packageName = "chat-command"
        override = true
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    explicitApi()
    sourceSets.forEach { it.languageSettings.optIn("kotlin.RequiresOptIn") }
}

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
