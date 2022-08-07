package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2750
 */

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val sortedNumbers = IntArray(numberOfInput) {
        reader.readLine().toInt()
    }.sorted()

    for (number in sortedNumbers) {
        writer.write(number.toString())
        writer.newLine()
    }
    writer.flush()
}