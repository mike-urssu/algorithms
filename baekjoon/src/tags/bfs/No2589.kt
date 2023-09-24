package tags.bfs

/**
 * https://www.acmicpc.net/problem/2589
 */
import java.util.LinkedList
import java.util.Queue

private var l = 0
private var w = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    l = input[0]
    w = input[1]

    graph = Array(l) { readln().toCharArray() }

    var max = Int.MIN_VALUE
    for (i in 0 until l) {
        for (j in 0 until w) {
            if (graph[i][j] == 'L') {
                max = max.coerceAtLeast(getDistance(i, j))
            }
        }
    }
    println(max)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getDistance(row: Int, col: Int): Int {
    val distances = Array(l) { IntArray(w) }
    val isVisited = Array(l) { BooleanArray(w) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    distances[row][col] = 0
    isVisited[row][col] = true
    queue.add(Pair(row, col))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 'L') {
                isVisited[nextX][nextY] = true
                distances[nextX][nextY] = distances[x][y] + 1
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return distances.maxOf { it.max() }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until l && y in 0 until w
