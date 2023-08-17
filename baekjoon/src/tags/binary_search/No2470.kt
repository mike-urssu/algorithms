package tags.binary_search

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/2470
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }.sorted()
    val solutions = intArrayOf(numbers.first(), numbers.last())

    var low = 0
    var high = numbers.lastIndex
    var min = solutions.sum()
    while (low < high) {
        val sum = numbers[low] + numbers[high]
        if (abs(sum) < abs(min)) {
            min = sum
            solutions[0] = numbers[low]
            solutions[1] = numbers[high]
        }

        if (sum >= 0) {
            high--
        } else {
            low++
        }
    }

    writer.write(solutions.joinToString(" "))
    writer.flush()
}
