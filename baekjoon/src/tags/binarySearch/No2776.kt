package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2776
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        reader.readLine()
        val numbers1 = reader.readLine().split(" ").map { it.toInt() }.sorted()
        reader.readLine()
        val numbers2 = reader.readLine().split(" ").map { it.toInt() }

        numbers2.forEach { number ->
            if (numbers1.binarySearch(number) >= 0) {
                writer.write("1\n")
            } else {
                writer.write("0\n")
            }
        }
    }
    writer.flush()
}
