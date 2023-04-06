package command

import solver.SimpleIterationSolver
import util.FileReader
import util.MatrixUtils
import util.NumberReader

class SolveSlaeCommand : AbstractCommand(
    "solve-slae",
    "решить СЛАУ, ввод через консоль \n" +
            "       -f <file_path> : ввод через файл\n" +
            "       -r <matrix_size> : случайная матрица"
) {

    override fun execute(args: List<String>) {

        if (args.size > 2) {
            if (args[1] == "-f") fileExecution(args[2])
            else if (args[1] == "-r") randomExecution(args[2])
            return
        }

        consoleExecution()

    }

    private fun randomExecution(arg: String) {

        var size = 3

        try {
            size = arg.toInt()
        } catch (e: Exception) {
            println("Введите число!")
            return
        }

        if (size > 20 || size < 2) println("Размер матрицы должен быть в пределе [2; 20]")

        val matrix = MutableList(size) { DoubleArray(size) { 0.0 } }
        val variables = MutableList(size) { 0.0 }

        MatrixUtils.generateRandomMatrix(size, matrix, variables)

        execution(matrix, variables)

    }

    private fun fileExecution(path: String) {
        val matrix = mutableListOf<DoubleArray>()
        val variables = mutableListOf<Double>()

        if (!FileReader.readMatrix(path, matrix, variables)) return

        execution(matrix, variables)

    }

    private fun consoleExecution() {
        val matrix = mutableListOf<DoubleArray>()
        val variables = mutableListOf<Double>()

        MatrixUtils.readMatrixFromConsole(matrix, variables)

        execution(matrix, variables)
    }

    private fun execution(matrix: MutableList<DoubleArray>, variables: MutableList<Double>) {

        if (!MatrixUtils.isDiagonallyDominant(matrix) && !MatrixUtils.convertToDiagonallyDominant(matrix)) {
            return
        }

        println("---Исходная матрица---\n")
        for (row in matrix) {
            row.forEach { print("$it ") }
            println("= ${variables[matrix.indexOf(row)]}")
        }
        println("\n----------------------")

        val x0 = DoubleArray(matrix.size) { 0.0 }

        val eps = NumberReader.readDouble("Введите точность: ")

        val x = SimpleIterationSolver.solve(matrix, variables, x0, eps)

        println("\nПриближения: ")
        for (i in x.indices) {
            println("x${i+1} = ${x[i]}")
        }
        println()

    }

}