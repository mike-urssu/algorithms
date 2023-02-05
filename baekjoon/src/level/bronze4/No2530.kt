package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2530
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (hour, min, sec) = reader.readLine().split(" ").map { it.toInt() }
    val seconds = reader.readLine().toInt()
    val totalSeconds = hour * 3600 + min * 60 + sec + seconds

    writer.write("${totalSeconds / 3600 % 24} ${totalSeconds % 3600 / 60} ${totalSeconds % 60}")
    writer.flush()
}
