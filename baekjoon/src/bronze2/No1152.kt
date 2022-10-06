package bronze2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1152
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val line = reader.readLine().trim()
    if (line.isEmpty()) {
        writer.write("0")
    } else {
        writer.write("${line.split(" ").size}")
    }
    writer.flush()
}