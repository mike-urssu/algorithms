package silver2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1012
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var graph: Array<IntArray>

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        setGraph(numbers[0], numbers[1], numbers[2])
        writer.write("${countWorms(numbers[0], numbers[1])}\n")
    }
    writer.flush()
}

private fun setGraph(height: Int, width: Int, vegetables: Int) {
    graph = Array(height) { IntArray(width) }
    repeat(vegetables) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        graph[numbers[0]][numbers[1]] = 1
    }
}

private fun countWorms(height: Int, width: Int): Int {
    var count = 0

    for (i in 0 until height) {
        for (j in 0 until width) {
            if (graph[i][j] == 1) {
                spreadWorm(i, j)
                count++
            }
        }
    }
    return count
}

private fun spreadWorm(i: Int, j: Int) {
    graph[i][j] = -1

    if (isInBoundary(i - 1, j) && graph[i - 1][j] == 1) {
        spreadWorm(i - 1, j)
    }
    if (isInBoundary(i, j + 1) && graph[i][j + 1] == 1) {
        spreadWorm(i, j + 1)
    }
    if (isInBoundary(i + 1, j) && graph[i + 1][j] == 1) {
        spreadWorm(i + 1, j)
    }
    if (isInBoundary(i, j - 1) && graph[i][j - 1] == 1) {
        spreadWorm(i, j - 1)
    }
}

private fun isInBoundary(i: Int, j: Int) = i in graph.indices && j in 0 until graph[i].size