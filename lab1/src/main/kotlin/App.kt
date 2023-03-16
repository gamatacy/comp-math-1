import command.CommandManager
import command.ExitCommand
import command.HelpCommand
import command.SolveCommand
import console.ConsoleManager
import solver.SimpleIterationSolver
import util.FileReader

fun main() {

    val commandManager = CommandManager()
    val consoleManager = ConsoleManager(commandManager)
    commandManager.registerCommands(
        HelpCommand(commandManager.getCommands()),
        ExitCommand(),
        SolveCommand()
    )
    consoleManager.run()




}