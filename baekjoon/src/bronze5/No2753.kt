package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2753
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val year = reader.readLine().toInt()
    val isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0
    writer.write("${if (isLeapYear) 1 else 0}")
    writer.flush()
}