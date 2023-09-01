package tags.bfs

/**
 * https://www.acmicpc.net/problem/2206
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    println(bfs())
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs(): Int {
    val isVisited = Array(n) { Array(m) { IntArray(2) } }
    val queue: Queue<Triple<Int, Int, Boolean>> = LinkedList()
    isVisited[0][0][1] = 1
    queue.add(Triple(0, 0, true))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second
        val isDestroyable = p.third
        if (x == n - 1 && y == m - 1) {
            return if (isDestroyable) {
                isVisited[x][y][1]
            } else {
                isVisited[x][y][0]
            }
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY)) {
                if (graph[nextX][nextY] == 0) {
                    if (isDestroyable && isVisited[nextX][nextY][1] == 0) {
                        isVisited[nextX][nextY][1] = isVisited[x][y][1] + 1
                        queue.add(Triple(nextX, nextY, true))
                    } else if (!isDestroyable && isVisited[nextX][nextY][0] == 0) {
                        isVisited[nextX][nextY][0] = isVisited[x][y][0] + 1
                        queue.add(Triple(nextX, nextY, false))
                    }
                }
                if (graph[nextX][nextY] == 1 && isDestroyable) {
                    isVisited[nextX][nextY][0] = isVisited[x][y][1] + 1
                    queue.add(Triple(nextX, nextY, false))
                }
            }
        }
    }
    return -1
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
