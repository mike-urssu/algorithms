package silver4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1015
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val sortedNumbers = numbers.sorted().toMutableList()

    for (number in numbers) {
        val index = sortedNumbers.indexOf(number)
        writer.write("$index ")
        sortedNumbers[index] = -1
    }
    writer.flush()
}