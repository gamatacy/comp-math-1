package util

import kotlin.math.abs
import kotlin.random.Random

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

    fun convertToDiagonallyDominant(matrix: MutableList<DoubleArray>): Boolean {
        val maxIndexes = mutableMapOf<Int, Int>()
        var count = 0

        for (i in 0 until matrix.size) {
            var absSum = 0.0
            var maxIndex = 0

            for (j in 0 until matrix.size) {
                absSum += abs(matrix[i][j])
                if (abs(matrix[i][j]) > abs(matrix[i][maxIndex])) {
                    maxIndex = j
                }
            }

            if (i == maxIndex) count++
            else maxIndexes[i] = maxIndex

        }

        if (count != matrix.size) {

            for (i in matrix.indices) {

                if (maxIndexes.containsKey(i)) {

                    for (j in matrix.indices) {

                        if (maxIndexes.containsKey(j)) {

                            if (i == maxIndexes[j] && maxIndexes[i] == j) {
                                val temp = matrix[i]
                                matrix[i] = matrix[j]
                                matrix[j] = temp
                                maxIndexes.remove(i)
                                maxIndexes.remove(j)
                                break
                            } else if (i == maxIndexes[j]) {
                                val temp = matrix[i]
                                matrix[i] = matrix[j]
                                matrix[j] = temp
                                maxIndexes[i]?.let { maxIndexes.replace(j, it) }
                                maxIndexes.remove(i)
                                break
                            }

                        }

                    }

                }

            }

        }

        if (maxIndexes.isNotEmpty()) {
            println("Не удалось достигнуть диагонального преобладания")
            return false
        }

        println("Матрица преобразована в диагонально преобладающую")
        return true
    }

    fun readMatrixFromConsole(matrix: MutableList<DoubleArray>, variables: MutableList<Double>) {
        var row: DoubleArray

        val matrixSize = NumberReader.readInt("Введите размерность матрицы: ")

        println("Введите коэффициенты матрицы через пробел")

        var i = 1

        while (i <= matrixSize) {

            print("$i строка: ")

            try {
                val tmp = readLine()?.trimEnd()
                row = tmp!!.split("\\s+".toRegex()).map { it.toDouble() }.toDoubleArray()
                if (row.size != matrixSize) {
                    println("Должно быть $matrixSize элементов!")
                    continue
                }
            } catch (e: Exception) {
                println("Введите числа через пробел!")
                continue
            }

            val variable = NumberReader.readDouble("Введите свободный член: ")

            matrix.add(row)
            variables.add(variable)
            i++

        }

    }

    fun generateRandomMatrix(size: Int, matrix: MutableList<DoubleArray>, variables: MutableList<Double>) {
        for (i in 0 until size) {
            var sum = 0.0
            for (j in 0 until size) {
                if (i != j) {
                    matrix[i][j] = Random.nextDouble(-100.0, 100.0)
                    sum += abs(matrix[i][j])
                }
            }

            if (Random.nextBoolean()) matrix[i][i] = Random.nextDouble(sum, sum * 2)
            else matrix[i][i] = Random.nextDouble(-sum * 2, -sum)

            variables[i] = Random.nextDouble(-100.0, 100.0)

        }
    }

}