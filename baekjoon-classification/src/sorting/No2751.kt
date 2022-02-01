package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class No2751 {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private val writer = BufferedWriter(OutputStreamWriter(System.out))
    lateinit var numbers: IntArray

    fun main() {
        val numberOfInput = reader.readLine().toInt()
        numbers = IntArray(numberOfInput)
        for (i in 0 until numberOfInput)
            numbers[i] = reader.readLine().toInt()

        quickSort(numbers, 0, numbers.size - 1)

        for (number in numbers) {
            writer.write(number.toString())
            writer.newLine()
        }
        writer.flush()
    }

    private fun quickSort(numbers: IntArray, startIndex: Int, endIndex: Int) {
        if (startIndex >= endIndex)
            return

        val pivot = startIndex
        var i = startIndex
        var j = endIndex

        while (i < j) {
            while (numbers[pivot] < numbers[j] && i < j)
                j--
            while (numbers[pivot] >= numbers[i] && i < j)
                i++
            swapNumbers(numbers, i, j)
        }
        swapNumbers(numbers, pivot, i)

        quickSort(numbers, startIndex, j - 1)
        quickSort(numbers, j + 1, endIndex)
    }

    private fun swapNumbers(numbers: IntArray, i: Int, j: Int) {
        val temp = numbers[i]
        numbers[i] = numbers[j]
        numbers[j] = temp
    }
}

fun main() {
    No2751().main()
}
