package solver

import kotlin.math.abs

object SimpleIterationSolver {

    fun solve(
        matrix: MutableList<DoubleArray>,
        variables: MutableList<Double>,
        x0: DoubleArray,
        eps: Double
    ): DoubleArray {
        val n = matrix.size
        var x = x0
        var iterationsCount = 0
        var error = Double.MAX_VALUE

        while (error > eps) {
            val xNew = DoubleArray(n) { 0.0 }

            for (i in 0 until n) {
                var sum = 0.0

                for (j in 0 until n) {
                    if (i != j) {
                        sum += matrix[i][j] * x[j]
                    }
                }

                xNew[i] = (variables[i] - sum) / matrix[i][i]
            }

            error = 0.0

            for (i in 0 until n) {
                error += abs(xNew[i] - x[i])
            }

            x = xNew
            iterationsCount++
        }

        println("Решение найдено за $iterationsCount итераций, погрешность: $error")
        return x
    }

}