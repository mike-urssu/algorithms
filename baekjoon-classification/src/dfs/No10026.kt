package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/10026
 */
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>
private var size = 0

private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    size = readLine().toInt()
    graph = Array(size) { CharArray(size) }
    for (i in 0 until size) {
        val input = readLine()
        for (j in 0 until size)
            graph[i][j] = input[j]
    }

    isVisited = Array(size) { BooleanArray(size) }
    var rgbCount = 0
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (!isVisited[i][j]) {
                rgbDfs(i, j, graph[i][j])
                rgbCount++
            }
        }
    }

    isVisited = Array(size) { BooleanArray(size) }
    var rbCount = 0
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (!isVisited[i][j]) {
                rbDfs(i, j, graph[i][j])
                rbCount++
            }
        }
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("$rgbCount $rbCount")
        flush()
    }
}

private fun rgbDfs(row: Int, col: Int, color: Char) {
    isVisited[row][col] = true

    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && !isVisited[nextRow][nextCol] && graph[nextRow][nextCol] == color)
            rgbDfs(nextRow, nextCol, color)
    }
}

private fun rbDfs(row: Int, col: Int, color: Char) {
    isVisited[row][col] = true

    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && !isVisited[nextRow][nextCol]) {
            val nextColor = graph[nextRow][nextCol]
            if ((color == 'B' && nextColor == 'B') || (color == 'R' || color == 'G') && (nextColor == 'R' || nextColor == 'G'))
                rbDfs(nextRow, nextCol, nextColor)
        }
    }
}

private fun isInBoundary(row: Int, col: Int) = row in 0 until size && col in 0 until size