package console

import command.CommandManager

class ConsoleManager(private val commandManager: CommandManager) {

    fun run() {
        while (true) {

            val input = readLine()

            val cmd = commandManager.getCommand(input)

            if (cmd != null) {
                cmd.execute()
            } else {
                println("Такой команды нет! Напишите 'help' для вывода списка доступных команд.")
            }

        }
    }

}