package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1253
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }.sorted()
    var count = 0

    numbers.forEachIndexed { index, number ->
        if (isGoodNumber(numbers, index, number)) {
            count++
        }
    }

    writer.write("$count")
    writer.flush()
}

private fun isGoodNumber(numbers: List<Int>, index: Int, number: Int): Boolean {
    var low = 0
    var high = numbers.lastIndex

    while (low < high) {
        if (low == index) {
            low++
        } else if (high == index) {
            high--
        } else {
            val sum = numbers[low] + numbers[high]
            if (sum == number) {
                return true
            } else if (sum > number) {
                high--
            } else {
                low++
            }
        }
    }
    return false
}
