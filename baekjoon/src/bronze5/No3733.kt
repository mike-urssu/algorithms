package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/3733
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val line = reader.readLine() ?: break
        val numbers = line.split(" ").map { it.toInt() }
        writer.write("${numbers[1] / (numbers[0] + 1)}\n")
    }
    writer.flush()
}