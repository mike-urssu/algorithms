package dfs

/**
 * https://www.acmicpc.net/problem/2573
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var height = 0
private var width = 0

private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var tokenizer = StringTokenizer(readLine())
    height = tokenizer.nextToken().toInt()
    width = tokenizer.nextToken().toInt()
    graph = Array(height) {
        tokenizer = StringTokenizer(readLine())
        IntArray(width) { tokenizer.nextToken().toInt() }
    }

    var count = 0
    var icebergCount = getIcebergCount()
    while (icebergCount == 1) {
        meltIceberg()
        icebergCount = getIcebergCount()
        count++
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${if (icebergCount == 0) 0 else count}")
        flush()
    }
}

private fun meltIceberg() {
    val heightsToReduce = getHeightsToReduce()
    reduceHeights(heightsToReduce)
}

private fun getHeightsToReduce(): Array<IntArray> {
    val heightsToReduce = Array(height) { i ->
        IntArray(width) { j -> graph[i][j] }
    }

    for (row in 1 until height) {
        for (col in 1 until width) {
            if (heightsToReduce[row][col] != 0)
                heightsToReduce[row][col] = getSurroundingSeas(row, col)
        }
    }
    return heightsToReduce
}

private fun getSurroundingSeas(row: Int, col: Int): Int {
    var seas = 0
    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && graph[nextRow][nextCol] == 0)
            seas++
    }
    return seas
}

private fun reduceHeights(heightsToReduce: Array<IntArray>) {
    for (row in 1 until height - 1) {
        for (col in 1 until width - 1)
            graph[row][col] -= heightsToReduce[row][col].coerceAtMost(graph[row][col])
    }
}

private fun isInBoundary(row: Int, col: Int) = row in 0 until height && col in 0 until width

private fun getIcebergCount(): Int {
    var icebergCount = 0
    isVisited = Array(height) { BooleanArray(width) }
    for (row in 1 until height - 1) {
        for (col in 1 until width - 1) {
            if (graph[row][col] != 0 && !isVisited[row][col]) {
                dfs(row, col)
                icebergCount++
            }
        }
    }
    return icebergCount
}

private fun dfs(row: Int, col: Int) {
    isVisited[row][col] = true

    for (i in 0 until 4) {
        val nextRow = row + dy[i]
        val nextCol = col + dx[i]
        if (isInBoundary(nextRow, nextCol) && !isVisited[nextRow][nextCol] && graph[nextRow][nextCol] != 0)
            dfs(nextRow, nextCol)
    }
}