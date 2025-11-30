package tags.bfs

/**
 * https://www.acmicpc.net/problem/16174
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    if (isReachable(n)) {
        println("HaruHaru")
    } else {
        println("Hing")
    }
}

private val dx = intArrayOf(0, 1)
private val dy = intArrayOf(1, 0)

private fun isReachable(n: Int): Boolean {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(0 to 0)
    val isVisited = Array(n) { BooleanArray(n) }
    isVisited[0][0] = true
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (k in 0 until 2) {
            val nextX = x + dx[k] * graph[x][y]
            val nextY = y + dy[k] * graph[x][y]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (nextX == n - 1 && nextY == n - 1) {
                    return true
                }

                queue.add(nextX to nextY)
                isVisited[nextX][nextY] = true
            }
        }
    }
    return false
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
