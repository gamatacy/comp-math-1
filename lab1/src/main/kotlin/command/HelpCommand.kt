package command

class HelpCommand(private val commands: Collection<AbstractCommand>) : AbstractCommand(
    "help",
    "вывести список команд",
) {

    override fun execute(args: List<String>) {
        println("--- Список доступных команд ---\n")
        for (cmd in commands) {
            println("${cmd.name} : ${cmd.description}")
        }
        println("\n-------------------------------")
    }

}