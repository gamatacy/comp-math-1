package solver

import kotlin.math.abs

object SecantMethodSolver {

    fun solve(
        f: (Double) -> Double, // Функция, уравнение которой нужно решить
        a: Double, // Левая граница интервала
        b: Double, // Правая граница интервала
        epsilon: Double
    ): Double {
        var x0 = a
        var x1 = b
        var iterations = 0

        while (abs(f(x1)) > epsilon) {

            x0 -= (x1 - x0) * f(x0) / (f(x1) - f(x0))
            x1 -= (x0 - x1) * f(x1) / (f(x0) - f(x1))

            iterations++
        }

        return x1

    }

}