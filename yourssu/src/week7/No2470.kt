package week7

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

    var leftIndex = 0
    var rightIndex = numbers.size - 1
    var min = Int.MAX_VALUE
    var twoSolutions = IntArray(2)

    while (leftIndex < rightIndex) {
        val sum = numbers[leftIndex] + numbers[rightIndex]
        if (min > abs(sum)) {
            min = abs(sum)
            twoSolutions = intArrayOf(numbers[leftIndex], numbers[rightIndex])
        }

        if (sum < 0) {
            leftIndex++
        } else {
            rightIndex--
        }
    }

    twoSolutions.forEach { writer.write("$it ") }
    writer.flush()
}