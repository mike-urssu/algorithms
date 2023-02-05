package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/14645
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val input = reader.readLine().split(" ").map { it.toInt() }
    repeat(input[0]) { reader.readLine() }
    writer.write("비와이")
    writer.flush()
}