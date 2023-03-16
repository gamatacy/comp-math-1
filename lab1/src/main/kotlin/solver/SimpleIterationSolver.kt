package solver

object SimpleIterationSolver {

    fun solve(A: MutableList<DoubleArray>, b: MutableList<Double>, x0: MutableList<Double>, maxIterations: Int, eps: Double): DoubleArray {
        val n = A.size
        var x = x0.toDoubleArray()
        for (e in A){
            println(e.contentToString())
        }
        var k = 0
        var error = Double.MAX_VALUE

        while (k < maxIterations && error > eps) {
            val x_new = DoubleArray(n) { 0.0 }

            for (i in 0 until n) {
                var sum = 0.0

                for (j in 0 until n) {
                    if (i != j) {
                        sum += A[i][j] * x[j]
                    }
                }

                x_new[i] = (b[i] - sum) / A[i][i]
            }

            error = 0.0

            for (i in 0 until n) {
                error += Math.abs(x_new[i] - x[i])
            }

            x = x_new
            k++
        }

        return x
    }

}