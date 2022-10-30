package week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11660
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var graph: Array<IntArray>
private lateinit var accumulatedSum: Array<IntArray>

fun main() {
    val input = reader.readLine().split(" ").map { it.toInt() }
    val size = input[0]
    val numberOfInput = input[1]

    setGraph(size)
    setAccumulatedSum(size)

    repeat(numberOfInput) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        writer.write(
            "${
                accumulatedSum[numbers[2]][numbers[3]] - accumulatedSum[numbers[0] - 1][numbers[3]] - accumulatedSum[numbers[2]][numbers[1] - 1] + accumulatedSum[numbers[0] - 1][numbers[1] - 1]
            }\n"
        )
    }
    writer.flush()
}

private fun setGraph(size: Int) {
    graph = Array(size) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }
}

private fun setAccumulatedSum(size: Int) {
    accumulatedSum = Array(size + 1) { IntArray(size + 1) }
    for (i in 1..size) {
        for (j in 1..size) {
            accumulatedSum[i][j] =
                accumulatedSum[i - 1][j] + accumulatedSum[i][j - 1] - accumulatedSum[i - 1][j - 1] + graph[i - 1][j - 1]
        }
    }
}