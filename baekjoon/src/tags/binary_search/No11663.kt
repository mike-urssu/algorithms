package tags.binary_search

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11663
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (_, m) = reader.readLine().split(" ").map { it.toInt() }
    val points = reader.readLine().split(" ").map { it.toInt() }.sorted()
    repeat(m) {
        val (from, to) = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${getLowerBound(points, to + 1) - getLowerBound(points, from)}\n")
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
