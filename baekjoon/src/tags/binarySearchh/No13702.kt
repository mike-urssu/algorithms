package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/13702
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, k) = reader.readLine().split(" ").map { it.toInt() }
    val drinks = List(n) { reader.readLine().toLong() }

    var low = 0L
    var high = Int.MAX_VALUE.toLong()
    while (low + 1 < high) {
        val mid = (low + high) / 2
        val div = drinks.sumOf { it / mid }
        if (div < k) {
            high = mid
        } else {
            low = mid
        }
    }

    writer.write("$low")
    writer.flush()
}
