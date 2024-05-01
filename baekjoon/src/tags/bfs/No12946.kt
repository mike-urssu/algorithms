package tags.bfs

/**
 * https://www.acmicpc.net/problem/12946
 */
import java.util.LinkedList
import java.util.Queue
import kotlin.system.exitProcess

private var n = 0
private lateinit var graph: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = getGraph()

    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] == 0) {
                bfs(i, j)
            }
        }
    }

    val max = graph.maxOf { it.max() }
    if (max == -1) {
        println(0)
    } else {
        println(max)
    }
}

private fun getGraph() =
    Array(n) {
        readln().toCharArray()
            .map {
                if (it == '-') {
                    -1
                } else {
                    0
                }
            }.toIntArray()
    }

private val dx = intArrayOf(-1, 0, 1, 1, 0, -1)
private val dy = intArrayOf(0, -1, -1, 0, 1, 1)

private fun bfs(row: Int, col: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(row to col)
    graph[row][col] = 1

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 6) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
                setColor(nextX, nextY)
                queue.add(nextX to nextY)
            }
        }
    }
}

private fun setColor(x: Int, y: Int) {
    val colors = BooleanArray(4).apply { this[0] = true }
    for (i in 0 until 6) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] > 0) {
            colors[graph[nextX][nextY]] = true
        }
    }

    val color = colors.indexOfFirst { !it }
    if (color == 3) {
        println(3)
        exitProcess(0)
    }
    graph[x][y] = color
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
