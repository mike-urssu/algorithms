package tags.binary_search

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2805
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (_, m) = reader.readLine().split(" ").map { it.toLong() }
    val numbers = reader.readLine().split(" ").map { it.toLong() }

    var low = 0L
    var high = numbers.max()
    while (low + 1 < high) {
        val mid = (low + high) / 2
        val sum = numbers.sumOf { (it - mid).coerceAtLeast(0) }
        if (sum >= m) {
            low = mid
        } else {
            high = mid
        }
    }

    writer.write("$low")
    writer.flush()
}
