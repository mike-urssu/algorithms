package sorting

import java.io.BufferedWriter
import java.io.OutputStreamWriter

class MergeSort {
    private val writer = BufferedWriter(OutputStreamWriter(System.out))

    private val numbers = intArrayOf(1, 10, 5, 8, 7, 6, 4, 3, 2, 9)
    private val sortedNumbers = IntArray(numbers.size)

    fun main() {
        mergeSort(numbers, 0, numbers.size - 1)
        for (number in numbers)
            writer.write("$number ")
        writer.flush()
    }

    private fun mergeSort(numbers: IntArray, startIndex: Int, endIndex: Int) {
        if (startIndex < endIndex) {
            val mid = (startIndex + endIndex) / 2
            mergeSort(numbers, startIndex, mid)
            mergeSort(numbers, mid + 1, endIndex)
            merge(numbers, startIndex, mid, endIndex)
        }
    }

    private fun merge(numbers: IntArray, startIndex: Int, midIndex: Int, endIndex: Int) {
        var i = startIndex
        var j = midIndex + 1
        var sortedIndex = startIndex

        while (i <= midIndex && j <= endIndex) {
            sortedNumbers[sortedIndex++] =
                if (numbers[i] <= numbers[j]) numbers[i++]
                else numbers[j++]
        }

        if (i > midIndex) {
            while (j <= endIndex)
                sortedNumbers[sortedIndex++] = numbers[j++]
        } else {
            while (i <= midIndex)
                sortedNumbers[sortedIndex++] = numbers[i++]
        }

        System.arraycopy(sortedNumbers, startIndex, numbers, startIndex, endIndex - startIndex + 1)
    }
}

fun main() {
    MergeSort().main()
}
