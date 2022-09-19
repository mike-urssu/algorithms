package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Collections

/**
 * https://www.acmicpc.net/problem/18870
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val sortedNumbers = numbers.distinct().sorted()
    numbers.forEach { number ->
        writer.write("${Collections.binarySearch(sortedNumbers, number)} ")
    }
    writer.flush()
}