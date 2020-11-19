package net.mamoe.mirai.console.plugins.chat.command

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object ChatCommandConfig : AutoSavePluginConfig("ChatCommand") {
    @ValueDescription("插件是否启用. 设置 false 时禁用插件.")
    val enabled: Boolean by value(true)

    /*
    @ValueDescription("特定情况时的响应配置")
    val events: Events by value()

    @Serializable
    data class Events(
        val onPermissionDenied: OnPermissionDenied,
    ) {
        @Serializable
        data class OnPermissionDenied(
        )
    }*/
}
