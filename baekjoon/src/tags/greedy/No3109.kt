package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/3109
 */
class No3109 {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    private lateinit var graph: MutableList<CharArray>
    private val dy = intArrayOf(-1, 0, 1)
    private val dx = intArrayOf(1, 1, 1)
    private var width = 0
    private var height = 0

    fun main() {
        setGraph()
        var count = 0
        for (row in 0 until height) {
            if (dfs(row, 0))
                count++
        }
        writer.write(count.toString())
        writer.flush()
    }

    private fun setGraph() {
        graph = arrayListOf()
        val input = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
        height = input[0]
        width = input[1]

        for (i in 0 until height) {
            val row = reader.readLine().toCharArray()
            graph.add(row)
        }
    }

    private fun dfs(row: Int, col: Int): Boolean {
        graph[row][col] = 'x'

        if (col == width - 1)
            return true

        for (i in 0 until 3) {
            val nextRow = row + dy[i]
            val nextCol = col + dx[i]
            if (isInBoundary(nextRow, nextCol) && graph[nextRow][nextCol] == '.') {
                if (dfs(nextRow, nextCol))
                    return true
            }
        }
        return false
    }

    private fun isInBoundary(row: Int, col: Int): Boolean {
        return col in 0 until width && row in 0 until height
    }
}

fun main() {
    No3109().main()
}
