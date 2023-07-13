package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2589
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>
private var max = 0

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    m = numbers[1]
    graph = Array(n) { readln().toCharArray() }

    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (graph[i][j] == 'L') {
                isVisited = Array(n) { BooleanArray(m) }
                bfs(i, j)
            }
        }
    }

    println(max)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs(x: Int, y: Int) {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    isVisited[x][y] = true
    queue.add(Triple(x, y, 0))

    while (queue.isNotEmpty()) {
        val position = queue.poll()
        max = max.coerceAtLeast(position.third)

        for (i in 0 until 4) {
            val nextX = position.first + dx[i]
            val nextY = position.second + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 'L') {
                isVisited[nextX][nextY] = true
                queue.add(Triple(nextX, nextY, position.third + 1))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
