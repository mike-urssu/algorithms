package tags.bfs

/**
 * https://www.acmicpc.net/problem/2178
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    m = numbers[1]
    graph = getGraph()
    bfs()
    println(graph.last().last())
}

private fun getGraph() =
    Array(n) {
        readln().toCharArray().map {
            if (it == '1') {
                0
            } else {
                -1
            }
        }.toIntArray()
    }

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs() {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    graph[0][0] = 1
    queue.add(Triple(0, 0, 1))

    while (queue.isNotEmpty()) {
        val cursor = queue.poll()
        for (i in 0 until 4) {
            val nextX = cursor.first + dx[i]
            val nextY = cursor.second + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
                graph[nextX][nextY] = cursor.third + 1
                queue.add(Triple(nextX, nextY, cursor.third + 1))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
