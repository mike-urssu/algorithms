package tags.bfs

/**
 * https://www.acmicpc.net/problem/16954
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<CharArray>
private lateinit var walls: List<Set<Pair<Int, Int>>>

fun main() {
    graph = Array(8) { readln().toCharArray() }
    walls = getWalls()
    if (isReachable()) {
        println(1)
    } else {
        println(0)
    }
}

private fun getWalls(): List<Set<Pair<Int, Int>>> {
    val walls = mutableListOf<MutableSet<Pair<Int, Int>>>().apply {
        repeat(8) { this.add(mutableSetOf()) }
    }
    (0 until 8).forEach { i ->
        (0 until 8).forEach { j ->
            if (graph[i][j] == '#') {
                walls[0].add(i to j)
            }
        }
    }

    (1 until 8).forEach { t ->
        walls[0].forEach { (x, y) ->
            if (isInBoundary(x + t, y)) {
                walls[t].add(x + t to y)
            }
        }
    }

    return walls
}

private val dx = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1, -1, -1, 0, 1, 1)

private fun isReachable(): Boolean {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    queue.add(Triple(7, 0, 0))

    while (queue.isNotEmpty()) {
        val (x, y, t) = queue.poll()
        if (x == 0 && y == 7) {
            return true
        }

        (0 until 9).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY)) {
                val isValid = if (t < 7) {
                    !walls[t].contains(nextX to nextY) && !walls[t + 1].contains(nextX to nextY)
                } else if (t == 7) {
                    !walls[t].contains(nextX to nextY)
                } else {
                    true
                }

                if (isValid) {
                    queue.add(Triple(nextX, nextY, t + 1))
                }
            }
        }
    }

    return false
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until 8 && y in 0 until 8
