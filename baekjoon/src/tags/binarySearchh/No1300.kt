package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1300
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()
    val k = reader.readLine().toInt()

    var low = 0
    var high = 1000000000

    while (low + 1 < high) {
        val mid = (low + high) / 2
        val count = (1..n).sumOf { (mid / it).coerceAtMost(n) }

        if (count >= k) {
            high = mid
        } else {
            low = mid
        }
    }

    writer.write("$high")
    writer.flush()
}
