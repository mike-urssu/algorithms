package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1654
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (k, n) = reader.readLine().split(" ").map { it.toInt() }
    val lines = mutableListOf<Int>()
    repeat(k) { lines.add(reader.readLine().toInt()) }

    var low = 0L
    var high = Long.MAX_VALUE
    while (low + 1 < high) {
        val mid = (low + high) / 2
        val sum = lines.sumOf { it / mid }
        if (sum < n) {
            high = mid
        } else {
            low = mid
        }
    }

    writer.write("$low")
    writer.flush()
}
