package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/9498
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    when (reader.readLine().toInt()) {
        in 90..100 -> {
            writer.write("A")
        }
        in 80..89 -> {
            writer.write("B")
        }
        in 70..79 -> {
            writer.write("C")
        }
        in 60..69 -> {
            writer.write("D")
        }
        else -> {
            writer.write("F")
        }
    }
    writer.flush()
}