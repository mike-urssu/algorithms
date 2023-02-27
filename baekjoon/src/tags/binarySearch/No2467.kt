package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/2467
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    val solutions = intArrayOf(numbers.first(), numbers.last())
    var low = 0
    var high = numbers.lastIndex
    while (low < high) {
        val sum = numbers[low] + numbers[high]
        if (abs(sum) < abs(solutions.sum())) {
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
