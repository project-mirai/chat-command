# chat-command
允许在聊天环境执行指令.

请先通过 `/perm` 为用户设置指定指令的权限. 详见 Mirai Console 的[权限文档](https://docs.mirai.mamoe.net/console/Permissions.html).


## 安装`chat-command`

### 使用 [Mirai Console Loader](https://github.com/iTXTech/mirai-console-loader) 安装`chat-command`

* `MCL` 支持自动更新插件，支持设置插件更新频道等功能

`./mcl --update-package net.mamoe:chat-command --channel stable --type plugin`

### 手动安装 `chat-command`

1. 运行 [Mirai Console](https://github.com/mamoe/mirai-console) 生成plugins文件夹
1. 从 [Releases](https://github.com/project-mirai/chat-command/releases) 下载`jar`并将其放入`plugins`文件夹中

## 可选配置 

### 文件 `ChatCommand.yml`

reply 输出 可选项 `NONE, USER, CONSOLE, ALL`

* `enabled` 插件是否启用. 设置 false 时禁用插件.
* `reply_unresolved_command_help` 参数不匹配时输出帮助对象. 默认 USER
* `reply_illegal_argument_help` 参数不匹配时输出帮助对象. 默认 USER
* `reply_permission_denied_help` 权限不足时输出帮助对象. 默认 CONSOLE
* `reply_intercepted_help` 指令被拦截时输出帮助对象. 默认 CONSOLE
* `reply_execution_failed_help` 指令解析失败时输出帮助对象. 默认 CONSOLE
