package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/9086
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val word = reader.readLine()
        writer.write("${word.first()}${word.last()}\n")
    }
    writer.flush()
}