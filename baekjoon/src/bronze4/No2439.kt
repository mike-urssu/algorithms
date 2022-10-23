package bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2439
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val number = reader.readLine().toInt()
    repeat(number) { i ->
        repeat(number - i - 1) {
            writer.write(" ")
        }
        repeat(i + 1) {
            writer.write("*")
        }
        writer.newLine()
    }
    writer.flush()

    writer.flush()
}