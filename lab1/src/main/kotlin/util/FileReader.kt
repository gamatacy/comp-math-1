package util

import java.io.File

object FileReader {

    fun readMatrix(path: String, matrix: MutableList<DoubleArray>, variables: MutableList<Double>) {
        val lines = File(path).readLines()

        for (i in 1 until lines.size) {
            matrix.add(lines[i].split(" ").map { it.toDouble() }.dropLast(1).toDoubleArray())
            variables.add(lines[i].split(" ").last().toDouble())
        }

    }


}