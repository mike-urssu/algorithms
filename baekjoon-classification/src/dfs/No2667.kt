package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2667
 */
private var size = 0
private var count = 0
private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    size = readLine().toInt()
    val graph = Array(size) { BooleanArray(size) }
    repeat(size) { i ->
        val row = readLine()
        graph[i] = BooleanArray(size) { j -> row[j] == '1' }
    }

    val houses = arrayListOf<Int>()
    for (i in graph.indices) {
        for (j in graph.indices) {
            if (graph[i][j]) {
                count = 0
                dfs(graph, i, j)
                houses.add(count)
            }
        }
    }

    houses.sort()

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${houses.size}")
        newLine()
        for (house in houses) {
            write("$house")
            newLine()
        }
        flush()
    }
}

private fun dfs(graph: Array<BooleanArray>, row: Int, col: Int) {
    graph[row][col] = false
    count++
    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && graph[nextRow][nextCol])
            dfs(graph, nextRow, nextCol)
    }
}

private fun isInBoundary(row: Int, col: Int) = row in 0 until size && col in 0 until size