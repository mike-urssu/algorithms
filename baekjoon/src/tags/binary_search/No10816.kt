package tags.binary_search

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10816
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine().toInt()
    val cards = reader.readLine().split(" ").map { it.toInt() }.sorted()
    reader.readLine().toInt()
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    numbers.forEach {
        writer.write("${getLowerBound(cards, it + 1) - getLowerBound(cards, it)} ")
    }
    writer.flush()
}

private fun getLowerBound(numbers: List<Int>, number: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] >= number) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
