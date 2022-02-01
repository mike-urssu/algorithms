package sorting

import java.io.BufferedWriter
import java.io.OutputStreamWriter

class QuickSort {
    private val writer = BufferedWriter(OutputStreamWriter(System.out))
    private val numbers = intArrayOf(1, 10, 5, 8, 7, 6, 4, 3, 2, 9)

    fun main() {
        quickSort(numbers, 0, numbers.size - 1)
        for (number in numbers)
            writer.write("$number ")
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
    QuickSort().main()
}
