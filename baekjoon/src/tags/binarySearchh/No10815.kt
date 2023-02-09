package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10815
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val cards = reader.readLine().split(" ").map { it.toInt() }.sorted()

    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    numbers.forEach { number ->
        if (cards.binarySearch(number) >= 0) {
            writer.write("1 ")
        } else {
            writer.write("0 ")
        }
    }
    writer.flush()
}
