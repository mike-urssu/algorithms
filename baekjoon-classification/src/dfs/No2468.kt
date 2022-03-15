package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/2468
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var size = 0
private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    size = readLine().toInt()
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    graph = Array(size) {
        val tokenizer = StringTokenizer(readLine())
        IntArray(size) {
            val number = tokenizer.nextToken().toInt()
            min = min.coerceAtMost(number)
            max = max.coerceAtLeast(number)
            number
        }
    }

    var safePlaces = 0
    for (height in 0 until max) {
        var count = 0
        isVisited = Array(size) { BooleanArray(size) }
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (!isVisited[i][j] && graph[i][j] > height) {
                    dfs(i, j, height)
                    count++
                }
            }
        }
        safePlaces = safePlaces.coerceAtLeast(count)
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("$safePlaces")
        flush()
    }
}

private fun dfs(row: Int, col: Int, height: Int) {
    isVisited[row][col] = true
    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && !isVisited[nextRow][nextCol] && graph[nextRow][nextCol] > height)
            dfs(nextRow, nextCol, height)
    }
}

private fun isInBoundary(row: Int, col: Int) = row in 0 until size && col in 0 until size
