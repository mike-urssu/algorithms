package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10869
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val a = numbers[0]
    val b = numbers[1]
    writer.write("${a + b}\n")
    writer.write("${a - b}\n")
    writer.write("${a * b}\n")
    writer.write("${a / b}\n")
    writer.write("${a % b}\n")
    writer.flush()
}