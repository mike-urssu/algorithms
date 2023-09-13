package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/2665
 */
import java.util.PriorityQueue
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var rooms: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().toCharArray().map { it.digitToInt() }.toIntArray() }
    rooms = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    println(getLeastBlackRooms())
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getLeastBlackRooms(): Int {
    val queue: Queue<Triple<Int, Int, Int>> = PriorityQueue { it, other ->
        it.third.compareTo(other.third)
    }

    rooms[0][0] = 0
    queue.add(Triple(0, 0, 0))

    while (queue.isNotEmpty()) {
        val (x, y, r) = queue.poll()
        if (rooms[x][y] < r) {
            continue
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY)) {
                if (graph[nextX][nextY] == 1) {
                    if (rooms[nextX][nextY] > rooms[x][y]) {
                        rooms[nextX][nextY] = rooms[x][y]
                        queue.add(Triple(nextX, nextY, rooms[nextX][nextY]))
                    }
                } else {
                    if (rooms[nextX][nextY] > rooms[x][y] + 1) {
                        rooms[nextX][nextY] = rooms[x][y] + 1
                        queue.add(Triple(nextX, nextY, rooms[nextX][nextY]))
                    }
                }
            }
        }
    }

    return rooms.last().last()
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
