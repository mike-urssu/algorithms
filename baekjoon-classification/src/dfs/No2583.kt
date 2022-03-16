package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/2583
 */
private lateinit var graph: Array<BooleanArray>
private var height = 0
private var width = 0

private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var tokenizer = StringTokenizer(readLine())
    height = tokenizer.nextToken().toInt()
    width = tokenizer.nextToken().toInt()
    graph = Array(height) { BooleanArray(width) }

    val numberOfInput = tokenizer.nextToken().toInt()
    repeat(numberOfInput) {
        tokenizer = StringTokenizer(readLine())
        val x1 = tokenizer.nextToken().toInt()
        val y1 = tokenizer.nextToken().toInt()
        val x2 = tokenizer.nextToken().toInt()
        val y2 = tokenizer.nextToken().toInt()
        for (y in y1 until y2) {
            for (x in x1 until x2)
                graph[y][x] = true
        }
    }

    val counts = arrayListOf<Int>()
    for (i in 0 until height) {
        for (j in 0 until width) {
            count = 0
            if (!graph[i][j]) {
                dfs(i, j)
                counts.add(count)
            }
        }
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${counts.size}")
        newLine()
        for (count in counts.sorted())
            write("$count ")
        flush()
    }
}

private fun dfs(row: Int, col: Int) {
    graph[row][col] = true
    count++
    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && !graph[nextRow][nextCol])
            dfs(nextRow, nextCol)
    }
}

private fun isInBoundary(row: Int, col: Int) = row in 0 until height && col in 0 until width