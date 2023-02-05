package tags.dfsAndBfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/1520
 */
private var height: Int = 0
private var width: Int = 0
private lateinit var graph: Array<IntArray>
private lateinit var dp: Array<IntArray>

private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var tokenizer = StringTokenizer(readLine())
    height = tokenizer.nextToken().toInt()
    width = tokenizer.nextToken().toInt()

    graph = Array(height) {
        tokenizer = StringTokenizer(readLine())
        IntArray(width) { tokenizer.nextToken().toInt() }
    }
    dp = Array(height) { IntArray(width) { -1 } }

    dfs(0, 0)

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${dp[0][0]}")
        flush()
    }
}

private fun dfs(row: Int, col: Int): Int {
    if (row == height - 1 && col == width - 1)
        return 1

    if (dp[row][col] != -1)
        return dp[row][col]

    dp[row][col] = 0
    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && graph[row][col] > graph[nextRow][nextCol])
            dp[row][col] += dfs(nextRow, nextCol)
    }
    return dp[row][col]
}

private fun isInBoundary(row: Int, col: Int) = row in 0 until height && col in 0 until width