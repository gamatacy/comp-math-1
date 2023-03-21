package util

import java.io.File

object FileReader {

    fun readMatrix(path: String, matrix: MutableList<DoubleArray>, variables: MutableList<Double>): Boolean {
        try {
            val lines = File(path).readLines()

            for (i in 1 until lines.size) {
                matrix.add(lines[i].split(" ").map { it.toDouble() }.dropLast(1).toDoubleArray())
                variables.add(lines[i].split(" ").last().toDouble())
            }
        } catch (e: Exception) {
            println("Неправильный путь к файлу")
            return false
        }

        return true

    }


}