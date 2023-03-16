package command

import solver.SimpleIterationSolver
import util.MatrixUtils

class SolveCommand : AbstractCommand(
    "solve",
    "решить СЛАУ, ввод через консоль"
) {
    override fun execute() {
        val matrix = mutableListOf<DoubleArray>()
        val variables = mutableListOf<Double>()
        val x0 = mutableListOf<Double>()

        try {
            print("Введите количество строк матрицы: ")
            val rowsCount = readLine()?.toInt()

            println("Введите коэффициенты матрицы через пробел: ")

            for (i in 1..rowsCount!!) {
                println("$i строка: ")
                val row = readLine()?.trimEnd()
                matrix.add(row!!.split("\\s+".toRegex()).map { it.toDouble() }.toDoubleArray())

                println("Введите свободный член: ")
                val variable = readLine()?.toDouble()

                if (variable != null) {
                    variables.add(variable)
                }

            }

            MatrixUtils.convertToDiagonallyDominant(matrix)

            for (m in matrix){
                println(m.contentToString())
            }

            for (i in 0 until rowsCount) {
                x0.add(0.0)
            }

            print("Введите максимальное число итераций: ")
            val maxIterations = readLine()?.toInt()
            print("Введите точность: ")
            val eps = readLine()?.toDouble()

            if (maxIterations == null || eps == null) throw NumberFormatException()

            val x = SimpleIterationSolver.solve(matrix, variables, x0, maxIterations, eps)

            println("x = ${x.contentToString()}")

        } catch (ne: NumberFormatException) {
            println("Введите число!")
            return
        } catch (nullException: NullPointerException) {
            println("Ошибка ввода!")
            return
        }

    }
}