package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10989
 */

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val numberOfInput = reader.readLine().toInt()
    val numbers = IntArray(numberOfInput) {
        reader.readLine().toInt()
    }

    val countOfNumbers = IntArray(10001)
    for (number in numbers)
        countOfNumbers[number]++

    for (index in countOfNumbers.indices) {
        for (i in 0 until countOfNumbers[index]) {
            writer.write("$index")
            writer.newLine()
        }
    }
    writer.flush()
}