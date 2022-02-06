package sorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/18870
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    reader.readLine()
    val numbers = reader.readLine().split(' ').map { it.toInt() }
    val sortedNumbers = numbers.toSortedSet().toList()

    for (number in numbers)
        writer.write("${getLowerBound(sortedNumbers, number)} ")
    writer.flush()
}

private fun getLowerBound(numbers: List<Int>, number: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] < number)
            low = mid
        else
            high = mid
    }
    return high
}
