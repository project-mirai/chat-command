# chat-command

允许在聊天环境执行指令.

请先通过 `/perm` 为用户设置指定指令的权限. 详见 Mirai Console 的[权限文档](https://docs.mirai.mamoe.net/console/BuiltInCommands.html#permissioncommand).

安装插件后无需配置, 机器人就会响应群内或私聊或其他聊天环境的用户的指令, 前提是用户拥有在该环境下执行某些指令的权限.

## 安装插件

### 使用 [Mirai Console Loader](https://github.com/iTXTech/mirai-console-loader)

* `MCL` 支持自动更新插件，支持设置插件更新频道等功能

`./mcl --update-package net.mamoe:chat-command --channel stable --type plugin`

### 手动安装 `chat-command`

1. 运行 [Mirai Console](https://github.com/mamoe/mirai-console) 生成 `plugins` 文件夹
2. 从 [Releases](https://github.com/project-mirai/chat-command/releases) 下载 `jar` 并将其放入 `plugins` 文件夹中

## 可选配置

### 文件 `ChatCommand.yml`

> 可在 config/ChatCommand.yml 编辑配置

* `enabled`: 插件是否启用. 设置 `false` 时禁用插件.

#### 配置错误提示

当插件遇到错误, 例如用户执行指令提供了过少参数时, 会通过配置中的设置来决定将错误信息发送给用户或者在日志 (控制台) 中记录.

对于以下配置, 可以选择使用:

- `NONE`: 忽略错误
- `USER`: 在聊天环境回复用户错误信息
- `CONSOLE`: 在日志 (控制台) 中记录
- `ALL`: 同时进行 `USER` 和 `CONSOLE`

| 配置名                             | 描述                | 默认值       | 
|---------------------------------|-------------------|-----------|
| `reply_unresolved_command_help` | 找不到指令的错误提示方式      | `USER`    |
| `reply_illegal_argument_help`   | 参数不匹配时的错误提示方式     | `USER`    |
| `reply_permission_denied_help`  | 权限不足时的错误提示方式      | `CONSOLE` |
| `reply_intercepted_help`        | 指令被其他插件拦截时的错误提示方式 | `CONSOLE` |
| `reply_execution_failed_help`   | 指令执行时出现插件错误的提示方式  | `CONSOLE` |
