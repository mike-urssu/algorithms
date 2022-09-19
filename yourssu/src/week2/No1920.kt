package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Collections

/**
 * https://www.acmicpc.net/problem/1920
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val array = reader.readLine().split(" ").map { it.toInt() }.sorted()
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    numbers.forEach { number ->
        writer.write(if (Collections.binarySearch(array, number) >= 0) "1" else "0")
        writer.newLine()
    }
    writer.flush()
}