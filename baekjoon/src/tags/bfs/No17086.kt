package tags.bfs

/**
 * https://www.acmicpc.net/problem/17086
 */
import java.util.PriorityQueue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = getGraph()

    bfs()

    val max = graph.maxOf { it.max() }
    println(max)
}

private fun getGraph() =
    Array(n) {
        readln().split(" ").map {
            val v = it.toInt()
            if (v == 0) {
                -1
            } else {
                0
            }
        }.toIntArray()
    }

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

private fun bfs() {
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }

    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (graph[i][j] == 0) {
                queue.add(Triple(i, j, 0))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val (x, y, v) = queue.poll()
        for (k in 0 until 8) {
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == -1) {
                graph[nextX][nextY] = v + 1
                queue.add(Triple(nextX, nextY, v + 1))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
