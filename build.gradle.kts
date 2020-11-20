plugins {
    val kotlinVersion = "1.4.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "1.0.0-dev-2"
}

group = "net.mamoe"
version = "0.1.0"

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}


kotlin.target.compilations.all {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}


tasks.create("buildCiJar", Jar::class) {
    dependsOn("buildPlugin")
    doLast {
        val buildPluginTask = tasks.getByName("buildPlugin", Jar::class)
        val buildPluginFile = buildPluginTask.archiveFile.get().asFile
        project.buildDir.subpath("ci").also {
            it.mkdirs()
        }.subpath("chat-command.jar").let {
            buildPluginFile.copyTo(it, true)
        }
    }
}

@Suppress("SpellCheckingInspection")
fun File.subpath(path: String): File = File(this, path)
