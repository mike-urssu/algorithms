package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/1987
 */
private lateinit var graph: Array<CharArray>
private var height = 0
private var width = 0
private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, -1, 0, 1)
private val set = HashSet<Char>()
private var count = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val tokenizer = StringTokenizer(readLine())
    height = tokenizer.nextToken().toInt()
    width = tokenizer.nextToken().toInt()

    graph = Array(height) {
        val input = readLine()
        CharArray(width) { i -> input[i] }
    }

    dfs(0, 0)

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("$count")
        flush()
    }
}

private fun dfs(row: Int, col: Int) {
    set.add(graph[row][col])
    count = count.coerceAtLeast(set.size)

    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]

        if (isInBoundary(nextRow, nextCol) && !set.contains(graph[nextRow][nextCol])) {
            dfs(nextRow, nextCol)
            set.remove(graph[nextRow][nextCol])
        }
    }
}

private fun isInBoundary(row: Int, col: Int) = row in 0 until height && col in 0 until width