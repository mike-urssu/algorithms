package level.bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1330
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    if (numbers[0] < numbers[1]) {
        writer.write("<")
    } else if (numbers[0] > numbers[1]) {
        writer.write(">")
    } else {
        writer.write("==")
    }
    writer.flush()
}