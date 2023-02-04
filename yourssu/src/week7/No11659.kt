package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11659
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val input = reader.readLine().split(" ").map { it.toInt() }
    val size = input[0] + 1
    val numberOfInput = input[1]

    val array = reader.readLine().split(" ").map { it.toInt() }
    val accumulatedSum = IntArray(size)
    for (i in 1 until accumulatedSum.size) {
        accumulatedSum[i] = accumulatedSum[i - 1] + array[i - 1]
    }

    repeat(numberOfInput) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${accumulatedSum[numbers[1]] - accumulatedSum[numbers[0] - 1]}\n")
    }
    writer.flush()
}