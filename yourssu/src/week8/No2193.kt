package week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2193
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val counts = LongArray(91)
    counts[1] = 1
    counts[2] = 1
    for (i in 3 until counts.size) {
        counts[i] = counts[i - 2] + counts[i - 1]
    }

    writer.write("${counts[reader.readLine().toInt()]}")
    writer.flush()
}
