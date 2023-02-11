package tags.math

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1252
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val binary = reader.readLine().split(" ")
        .map { it.toBigInteger(2) }
        .sumOf { it }
        .toString(2)
    writer.write(binary)
    writer.flush()
}
