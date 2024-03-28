package tags.bfs

/**
 * https://www.acmicpc.net/problem/18405
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<IntArray>

fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val (s, x, y) = readln().split(" ").map { it.toInt() }
    spread(n, s)
    println(graph[x - 1][y - 1])
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun spread(n: Int, s: Int) {
    val viruses = getViruses(n)
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    viruses.forEach { (x, y) ->
        queue.add(Triple(x, y, 0))
    }

    while (queue.isNotEmpty()) {
        val (x, y, t) = queue.poll()
        if (t == s) {
            continue
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(n, nextX, nextY) && graph[nextX][nextY] == 0) {
                graph[nextX][nextY] = graph[x][y]
                queue.add(Triple(nextX, nextY, t + 1))
            }
        }
    }
}

private fun getViruses(n: Int): List<Pair<Int, Int>> {
    val viruses = mutableListOf<Pair<Int, Int>>()
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] != 0) {
                viruses.add(i to j)
            }
        }
    }
    return viruses.sortedWith { (x1, y1), (x2, y2) ->
        graph[x1][y1].compareTo(graph[x2][y2])
    }
}

private fun isInBoundary(n: Int, x: Int, y: Int) =
    x in 0 until n && y in 0 until n
