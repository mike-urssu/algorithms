package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/1012
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private var height: Int = 0
private var width: Int = 0
private lateinit var graph: Array<IntArray>

private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        var count = 0

        var tokenizer = StringTokenizer(reader.readLine())
        height = tokenizer.nextToken().toInt()
        width = tokenizer.nextToken().toInt()
        val numberOfInput = tokenizer.nextToken().toInt()

        graph = Array(height) { IntArray(width) }
        repeat(numberOfInput) {
            tokenizer = StringTokenizer(reader.readLine())
            val row = tokenizer.nextToken().toInt()
            val col = tokenizer.nextToken().toInt()
            graph[row][col] = 1
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

private fun dfs(row: Int, col: Int) {
    graph[row][col] = -1
    for (i in 0..3) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && graph[nextRow][nextCol] == 1)
            dfs(nextRow, nextCol)
    }
}

private fun isInBoundary(row: Int, col: Int) = row in 0 until height && col in 0 until width