package util

import java.io.File

object FileReader {

    fun readMatrixSize(path: String): Int{
        val lines = File(path).readLines()
        return lines[0].toInt()
    }

    fun readMatrix(path: String): MutableList<DoubleArray> {
        val lines = File(path).readLines()
        val matrix = mutableListOf<DoubleArray>()

        for (i in 1 until lines.size) {
            matrix.add(lines[i].split(" ").map { it.toDouble() }.dropLast(1).toDoubleArray())
        }

        return matrix

    }

    fun readFreeVariables(path: String): MutableList<Double> {
        val lines = File(path).readLines()
        val variables = mutableListOf<Double>()

        for (i in 1 until lines.size) {
            variables.add(lines[i].split(" ").last().toDouble())
        }

        return variables

    }

}