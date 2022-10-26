package bronze5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10807
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val countOfNumbers = mutableMapOf<Int, Int>()

    reader.readLine()
    reader.readLine().split(" ").map { it.toInt() }
        .forEach { countOfNumbers[it] = countOfNumbers.getOrDefault(it, 0) + 1 }

    writer.write("${countOfNumbers.getOrDefault(reader.readLine().toInt(), 0)}")
    writer.flush()
}