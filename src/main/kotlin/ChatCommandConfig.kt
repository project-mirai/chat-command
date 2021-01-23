/*
 * Copyright 2019-2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE version 3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.console.plugins.chat.command

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object ChatCommandConfig : AutoSavePluginConfig("ChatCommand") {
    @ValueDescription("插件是否启用. 设置 false 时禁用插件.")
    val enabled: Boolean by value(true)

    @ValueDescription("是否在参数不匹配时输出帮助.")
    val replyUnresolvedCommandHelp by value(true)

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
