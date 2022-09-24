package week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1813
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val counts = IntArray(51)

    reader.readLine()
    reader.readLine().split(" ").map { it.toInt() }.forEach { counts[it]++ }

    for (i in counts.size - 1 downTo 0) {
        if (i == counts[i]) {
            writer.write("$i")
            writer.flush()
            return
        }
    }

    writer.write("-1")
    writer.flush()
}