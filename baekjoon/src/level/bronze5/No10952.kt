package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10952
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    while (true) {
        val line = reader.readLine()
        if (line == "0 0") {
            break
        }
        writer.write("${line.split(" ").sumOf { it.toInt() }}\n")
    }
    writer.flush()
}