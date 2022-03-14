package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/4963
 */
private val writer = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var tokenizer: StringTokenizer
private var width = 0
private var height = 0
private lateinit var graph: Array<IntArray>

private val dx = intArrayOf(1, 1, 0, -1, -1, -1, 0, 1)
private val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        var count = 0

        tokenizer = StringTokenizer(readLine())
        width = tokenizer.nextToken().toInt()
        height = tokenizer.nextToken().toInt()

        if (width == 0 && height == 0)
            break

        graph = Array(height) { IntArray(width) }
        for (i in 0 until height) {
            tokenizer = StringTokenizer(readLine())
            for (j in 0 until width)
                graph[i][j] = tokenizer.nextToken().toInt()
        }

        for (i in 0 until height) {
            for (j in 0 until width) {
                if (graph[i][j] == 1) {
                    dfs(i, j)
                    count++
                }
            }
        }
        writer.write("$count")
        writer.newLine()
    }
    writer.flush()
}

private fun isInBoundary(row: Int, col: Int): Boolean = row in 0 until height && col in 0 until width

private fun dfs(row: Int, col: Int) {
    graph[row][col] = -1

    for (i in 0 until 8) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && graph[nextRow][nextCol] == 1)
            dfs(nextRow, nextCol)
    }
}