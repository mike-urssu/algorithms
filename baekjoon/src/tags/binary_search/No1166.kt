package tags.binary_search

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1166
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, l, w, h) = reader.readLine().split(" ").map { it.toLong() }
    var low = 0.0
    var high = 1000000001.0

    repeat(1000) {
        val mid = (low + high) / 2
        val boxes = (l / mid).toLong() * (w / mid).toLong() * (h / mid).toLong()
        if (boxes >= n) {
            low = mid
        } else {
            high = mid
        }
    }

    writer.write("$low")
    writer.flush()
}
