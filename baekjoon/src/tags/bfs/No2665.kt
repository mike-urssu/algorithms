package tags.bfs

/**
 * https://www.acmicpc.net/problem/2665
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    println(getLeastBlackRooms())
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getLeastBlackRooms(): Int {
    val rooms = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    rooms[0][0] = 0
    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY)) {
                if (graph[nextX][nextY] == 0) {
                    if (rooms[nextX][nextY] > rooms[x][y] + 1) {
                        rooms[nextX][nextY] = rooms[x][y] + 1
                        queue.add(Pair(nextX, nextY))
                    }
                } else {
                    if (rooms[nextX][nextY] > rooms[x][y]) {
                        rooms[nextX][nextY] = rooms[x][y]
                        queue.add(Pair(nextX, nextY))
                    }
                }
            }
        }
    }

    return rooms.last().last()
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
