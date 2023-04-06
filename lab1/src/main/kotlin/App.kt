import command.*
import console.ConsoleManager

fun main() {

    val commandManager = CommandManager()
    val consoleManager = ConsoleManager(commandManager)
    commandManager.registerCommands(
        HelpCommand(commandManager.getCommands()),
        ExitCommand(),
        SolveSlaeCommand(),
        SolveNonLeCommand()
    )
    consoleManager.run()

}