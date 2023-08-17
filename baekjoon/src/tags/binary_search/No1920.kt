package tags.binary_search

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1920
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }.sorted()
    reader.readLine()
    reader.readLine().split(" ").map { it.toInt() }
        .forEach {
            if (numbers.binarySearch(it) >= 0) {
                writer.write("1")
            } else {
                writer.write("0")
            }
            writer.newLine()
        }
    writer.flush()
}
