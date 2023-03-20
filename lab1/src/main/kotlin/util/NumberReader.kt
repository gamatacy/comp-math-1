package util

object NumberReader {

    fun readInt(message: String): Int {
        var tmp: Int
        while (true) {
            print(message)

            try {
                tmp = readLine()!!.toInt()
            } catch (ne: NumberFormatException) {
                println("Введите число!")
                continue
            }

            return tmp

        }
    }

    fun readDouble(message: String): Double {
        var tmp: Double
        while (true) {
            print(message)

            try {
                tmp = readLine()!!.toDouble()
            } catch (ne: NumberFormatException) {
                println("Введите число!")
                continue
            }

            return tmp

        }
    }


}