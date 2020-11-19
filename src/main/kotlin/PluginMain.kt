package net.mamoe.mirai.console.plugins.chat.command

import kotlinx.coroutines.CoroutineExceptionHandler
import net.mamoe.mirai.console.command.Command
import net.mamoe.mirai.console.command.CommandExecuteResult
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.command.CommandSender.Companion.toCommandSender
import net.mamoe.mirai.console.command.descriptor.ExperimentalCommandDescriptors
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.console.plugins.chat.command.ChatCommandConfig.enabled
import net.mamoe.mirai.console.util.ConsoleExperimentalApi
import net.mamoe.mirai.event.Listener
import net.mamoe.mirai.event.subscribeAlways
import net.mamoe.mirai.message.MessageEvent


object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "net.mamoe.mirai.console.chat-command",
        version = "0.1.0"
    )
) {
    @OptIn(ConsoleExperimentalApi::class, ExperimentalCommandDescriptors::class)
    override fun onEnable() {
        ChatCommandConfig.reload()
        commandListener = subscribeAlways(
            coroutineContext = CoroutineExceptionHandler { _, throwable ->
                logger.error(throwable)
            },
            concurrency = Listener.ConcurrencyKind.CONCURRENT,
            priority = Listener.EventPriority.NORMAL
        ) call@{
            if (!enabled) return@call

            val sender = this.toCommandSender()

            fun isDebugging(command: Command?): Boolean {
                /*
                if (command?.prefixOptional == false || message.content.startsWith(CommandManager.commandPrefix)) {
                    if (MiraiConsoleImplementationBridge.loggerController.shouldLog("console.debug", SimpleLogger.LogPriority.DEBUG)) {
                        return true
                    }
                }*/
                return false
            }

            when (val result = CommandManager.executeCommand(sender, message)) {
                is CommandExecuteResult.PermissionDenied -> {
                    if (isDebugging(result.command)) {
                        sender.sendMessage("权限不足. ${CommandManager.commandPrefix}${result.command.primaryName} 需要权限 ${result.command.permission.id}.")
                        // intercept()
                    }
                }
                is CommandExecuteResult.IllegalArgument -> {
                    result.exception.message?.let { sender.sendMessage(it) }
                    // intercept()
                }
                is CommandExecuteResult.Success -> {
                    //  intercept()
                }
                is CommandExecuteResult.ExecutionFailed -> {
                    sender.catchExecutionException(result.exception)
                    // intercept()
                }
                is CommandExecuteResult.Intercepted -> {
                    if (isDebugging(result.command)) {
                        sender.sendMessage("指令执行被拦截, 原因: ${result.reason}")
                    }
                }
                is CommandExecuteResult.UnmatchedSignature,
                is CommandExecuteResult.UnresolvedCommand,
                -> {
                    // noop
                }
            }
        }
    }

    internal lateinit var commandListener: Listener<MessageEvent>
}