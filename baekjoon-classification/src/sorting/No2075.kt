package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2075
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val size = reader.readLine().toInt()
    val numbers = arrayListOf<IntArray>()
    for (i in 0 until size) {
        val row = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        numbers.add(row)
    }

    val rows = IntArray(size) { size - 1 }
    val highestNumbers = numbers[size - 1]
    for (i in 0 until size - 1) {
        val index = getIndex(highestNumbers)
        highestNumbers[index] = numbers[rows[index]-- - 1][index]
    }

    writer.write(getHighestNumber(highestNumbers).toString())
    writer.flush()
}

private fun getIndex(numbers: IntArray): Int {
    var index = 0
    var max = Int.MIN_VALUE
    for (i in numbers.indices) {
        if (max < numbers[i]) {
            max = numbers[i]
            index = i
        }
    }
    return index
}

private fun getHighestNumber(numbers: IntArray): Int {
    var max = Int.MIN_VALUE
    for (i in numbers.indices)
        max = max.coerceAtLeast(numbers[i])
    return max
}
