package week3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10816
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val countOfNumbers = mutableMapOf<String, Int>()

    reader.readLine()
    reader.readLine().split(" ").forEach { number ->
        countOfNumbers[number] = countOfNumbers.getOrDefault(number, 0) + 1
    }

    reader.readLine()
    reader.readLine().split(" ").forEach { number ->
        writer.write("${countOfNumbers.getOrDefault(number, 0)} ")
    }
    writer.flush()
}