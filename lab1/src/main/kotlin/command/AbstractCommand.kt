package command

abstract class AbstractCommand(
    val name: String,
    val description: String
) {

    abstract fun execute()

}