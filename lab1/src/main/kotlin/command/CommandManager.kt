package command

class CommandManager {

    private val commands = mutableMapOf<String, AbstractCommand>()

    fun registerCommands(vararg commands: AbstractCommand) {
        for (cmd in commands) {
            this.commands[cmd.name] = cmd
        }
    }

    fun getCommands(): Collection<AbstractCommand>{
        return this.commands.values
    }

    fun getCommand(name: String?): AbstractCommand? {
        return commands[name]
    }

}