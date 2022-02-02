package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1427
 */
class No1427 {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private val writer = BufferedWriter(OutputStreamWriter(System.out))
    private lateinit var numbers: IntArray
    private lateinit var sortedNumbers: IntArray

    fun main() {
        numbers = reader.readLine().toCharArray().map { it.digitToInt() }.toIntArray()
        sortedNumbers = IntArray(numbers.size)

        mergeSort(numbers, 0, numbers.size - 1)

        for (number in numbers)
            writer.write(number.toString())
        writer.flush()
    }

    private fun mergeSort(numbers: IntArray, startIndex: Int, endIndex: Int) {
        if (startIndex < endIndex) {
            val midIndex = (startIndex + endIndex) / 2
            mergeSort(numbers, startIndex, midIndex)
            mergeSort(numbers, midIndex + 1, endIndex)
            merge(numbers, startIndex, midIndex, endIndex)
        }
    }

    private fun merge(numbers: IntArray, startIndex: Int, midIndex: Int, endIndex: Int) {
        if (startIndex >= endIndex)
            return

        var i = startIndex
        var j = midIndex + 1
        var sortedIndex = startIndex

        while (i <= midIndex && j <= endIndex) {
            sortedNumbers[sortedIndex++] =
                if (numbers[i] >= numbers[j]) numbers[i++]
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
    No1427().main()
}
