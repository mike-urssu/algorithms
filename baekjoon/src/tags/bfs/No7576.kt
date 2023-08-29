package tags.bfs

/**
 * https://www.acmicpc.net/problem/7576
 */
import java.util.LinkedList
import java.util.Queue

private var m = 0
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private lateinit var dates: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    graph = getGraph(n)
    isVisited = Array(n) { BooleanArray(m) }
    dates = Array(n) { IntArray(m) }

    bfs()

    if (graph.any { row -> row.any { it == 0 } }) {
        println(-1)
    } else {
        println(dates.maxOf { row -> row.max() })
    }
}

private fun getGraph(n: Int) =
    Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs() {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1) {
                isVisited[i][j] = true
                queue.add(Pair(i, j))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until 4) {
            val nextX = p.first + dx[i]
            val nextY = p.second + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 0) {
                graph[nextX][nextY] = graph[p.first][p.second] + 1
                dates[nextX][nextY] = dates[p.first][p.second] + 1
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
