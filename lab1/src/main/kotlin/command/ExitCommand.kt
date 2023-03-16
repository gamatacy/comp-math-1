package command

import kotlin.system.exitProcess

class ExitCommand: AbstractCommand(
    "exit",
    "завершить работу программы"
) {
    override fun execute() {
        exitProcess(0)
    }
}