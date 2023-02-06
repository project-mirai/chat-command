/*
 * Copyright 2019-2023 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE version 3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.console.plugins.chat.command

import net.mamoe.mirai.console.data.*

public object ChatCommandConfig : AutoSavePluginConfig("ChatCommand") {
    @ValueDescription("插件是否启用. 设置 false 时禁用插件.")
    public val enabled: Boolean by value(true)

    /**
     * @since 0.6
     */
    @ValueName("reply_unresolved_command_help")
    @ValueDescription("参数不匹配时输出帮助对象.")
    public val replyUnresolvedCommandHelp: ReplyHelp by value(ReplyHelp.USER)

    /**
     * @since 0.6
     */
    @ValueName("reply_illegal_argument_help")
    @ValueDescription("非法参数时输出帮助对象.")
    public val replyIllegalArgumentHelp: ReplyHelp by value(ReplyHelp.USER)

    /**
     * @since 0.6
     */
    @ValueName("reply_permission_denied_help")
    @ValueDescription("权限不足时输出帮助对象.")
    public val replyPermissionDeniedHelp: ReplyHelp by value(ReplyHelp.CONSOLE)

    /**
     * @since 0.6
     */
    @ValueName("reply_intercepted_help")
    @ValueDescription("指令被拦截时输出帮助对象.")
    public val replyInterceptedHelp: ReplyHelp by value(ReplyHelp.CONSOLE)

    /**
     * @since 0.6
     */
    @ValueName("reply_execution_failed_help")
    @ValueDescription("指令解析失败时输出帮助对象.")
    public val replyExecutionFailedHelp: ReplyHelp by value(ReplyHelp.CONSOLE)
}
