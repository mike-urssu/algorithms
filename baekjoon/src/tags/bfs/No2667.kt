package tags.bfs

/**
 * https://www.acmicpc.net/problem/2667
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    isVisited = Array(n) { BooleanArray(n) }

    var group = 1
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 1 && !isVisited[i][j]) {
                bfs(i, j, group++)
            }
        }
    }

    val groups = mutableListOf<Int>()
    for (i in 1 until group) {
        groups.add(graph.sumOf { row -> row.count { it == i } })
    }
    println(groups.size)
    groups.sorted().forEach { println(it) }
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)

private fun bfs(x: Int, y: Int, group: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    graph[x][y] = group
    queue.add(Pair(x, y))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until 4) {
            val nextX = p.first + dx[i]
            val nextY = p.second + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 1) {
                isVisited[nextX][nextY] = true
                graph[nextX][nextY] = group
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
