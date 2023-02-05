package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1476
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val years = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    val years2 = intArrayOf(1, 1, 1)
    var count = 1

    while (!years.contentEquals(years2)) {
        count++
        years2[0] = ((years2[0] + 1) % 16).coerceAtLeast(1)
        years2[1] = ((years2[1] + 1) % 29).coerceAtLeast(1)
        years2[2] = ((years2[2] + 1) % 20).coerceAtLeast(1)
    }

    writer.write("$count")
    writer.flush()
}