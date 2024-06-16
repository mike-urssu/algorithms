package tags.bfs

/**
 * https://www.acmicpc.net/problem/16173
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    if (canReach()) {
        println("HaruHaru")
    } else {
        println("Hing")
    }
}

private fun canReach(): Boolean {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val isVisited = Array(n) { BooleanArray(n) }
    queue.add(0 to 0)
    isVisited[0][0] = true

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        val nextX = x + graph[x][y]
        val nextY = y + graph[x][y]
        if (isInBoundary(x, nextY) && !isVisited[x][nextY]) {
            queue.add(x to nextY)
            isVisited[x][nextY] = true
        }
        if (isInBoundary(nextX, y) && !isVisited[nextX][y]) {
            queue.add(nextX to y)
            isVisited[nextX][y] = true
        }
    }

    return isVisited[n - 1][n - 1]
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
