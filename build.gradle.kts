plugins {
    val kotlinVersion = "1.4.20"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "1.1.0"
}

group = "net.mamoe"
version = "0.1.1"

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
