package util

import kotlin.math.abs

object MatrixUtils {

    fun isDiagonallyDominant(matrix: MutableList<DoubleArray>): Boolean {
        for (i in 0 until matrix.size) {
            var rowSum = 0.0
            for (j in 0 until matrix.size) {
                if (i != j) {
                    rowSum += abs(matrix[i][j])
                }
            }
            if (abs(matrix[i][i]) < rowSum) {
                return false
            }
        }
        return true
    }

    fun convertToDiagonallyDominant(matrix: MutableList<DoubleArray>) {
        for (i in 0 until matrix.size) {
            var absSum = 0.0
            var maxIndex = 0

            for (j in 0 until matrix.size) {
                absSum += abs(matrix[i][j])
                if (abs(matrix[i][j]) > abs(matrix[i][maxIndex])) {
                    maxIndex = j
                }
            }

            if (abs(matrix[i][maxIndex]) >= absSum - abs(matrix[i][maxIndex])) {
                val temp = matrix[i][i]
                matrix[i][i] = matrix[i][maxIndex]
                matrix[i][maxIndex] = temp
            } else {
                return
            }

        }
    }

}