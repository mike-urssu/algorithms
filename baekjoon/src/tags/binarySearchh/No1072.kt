package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1072
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (x, y) = reader.readLine().split(" ").map { it.toLong() }
    val z = ((y * 100) / x).toInt()

    if (z >= 99) {
        writer.write("-1")
    } else {
        var low = 0
        var high = 1000000000
        while (low + 1 < high) {
            val mid = (low + high) / 2
            if ((y + mid) * 100 / (x + mid) > z) {
                high = mid
            } else {
                low = mid
            }
        }

        writer.write("$high")
    }
    writer.flush()
}
