package command

import solver.SecantMethodSolver
import kotlin.math.ln
import kotlin.math.pow

class SolveNonLeCommand : AbstractCommand(
    "solve-nle",
    "решить нелинейное уравнение\n" +
            "       -f <file_path> : ввод через файл"
) {
    override fun execute(args: List<String>) {
        val func: (Double) -> Double = { x -> ln(x) + ((x+1)).pow(3)}
        val a = 0.1
        val b = 1.0
        print("ans: ")
        println(
            SecantMethodSolver.solve(
                func, a, b, 1e-6
            )
        )
    }
}