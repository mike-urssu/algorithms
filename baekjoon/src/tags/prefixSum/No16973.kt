package tags.prefixSum

import java.util.LinkedList
import java.util.Queue

/**
 * https://www.acmicpc.net/problem/16973
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private lateinit var prefixSum: Array<IntArray>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    isVisited = Array(n) { BooleanArray(m) }
    setPrefixSum(n, m)

    val s = readln().split(" ").map { it.toInt() }
    val h = s[0]
    val w = s[1]
    val sr = s[2] - 1
    val sc = s[3] - 1
    val fr = s[4] - 1
    val fc = s[5] - 1

    var count = -1

    val queue: Queue<Point> = LinkedList()
    queue.add(Point(sr, sc, 0))
    isVisited[sr][sc] = true

    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(-1, 0, 1, 0)

    while (queue.isNotEmpty()) {
        val point = queue.poll()

        if (point.x == fr && point.y == fc) {
            count = point.count
            break
        }

        for (i in 0 until 4) {
            val nextRow = point.x + dx[i]
            val nextCol = point.y + dy[i]
            if (isInBoundary(n, m, h, w, nextRow, nextCol) && !isVisited[nextRow][nextCol]) {
                if (isAllZero(h, w, nextRow, nextCol)) {
                    queue.add(Point(nextRow, nextCol, point.count + 1))
                    isVisited[nextRow][nextCol] = true
                }
            }
        }
    }

    println(count)
}

private fun setPrefixSum(n: Int, m: Int) {
    prefixSum = Array(n + 1) { IntArray(m + 1) }
    (1..n).forEach { i ->
        (1..m).forEach { j ->
            prefixSum[i][j] = graph[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1]
        }
    }
}

private class Point(val x: Int, val y: Int, val count: Int)

private fun isInBoundary(n: Int, m: Int, h: Int, w: Int, row: Int, col: Int) =
    row in 0 until n &&
            row + h - 1 in 0 until n &&
            col in 0 until m &&
            col + w - 1 in 0 until m

private fun isAllZero(h: Int, w: Int, row: Int, col: Int) =
    prefixSum[row + h][col + w] - prefixSum[row + h][col] - prefixSum[row][col + w] + prefixSum[row][col] == 0
