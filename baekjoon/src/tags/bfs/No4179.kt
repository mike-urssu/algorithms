package tags.bfs

/**
 * https://www.acmicpc.net/problem/4179
 */
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

private var r = 0
private var c = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    graph = Array(r) { readln().toCharArray() }

    val time = getTime()
    if (time == Int.MAX_VALUE) {
        println("IMPOSSIBLE")
    } else {
        println(time)
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getTime(): Int {
    val src = find('J')[0]
    val times = Array(r) { IntArray(c) { Int.MAX_VALUE } }
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }
    val fires = getFires()

    times[src.first][src.second] = 0
    queue.add(Triple(src.first, src.second, 0))

    while (queue.isNotEmpty()) {
        val (x, y, t) = queue.poll()
        if (isEscaped(x, y)) {
            return t + 1
        }

        if (times[x][y] < t) {
            continue
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (
                isInBoundary(nextX, nextY)
                && graph[nextX][nextY] == '.'
                && times[nextX][nextY] > times[x][y] + 1
                && times[x][y] + 1 < fires[nextX][nextY]
            ) {
                times[nextX][nextY] = times[x][y] + 1
                queue.add(Triple(nextX, nextY, t + 1))
            }
        }
    }

    return Int.MAX_VALUE
}

private fun getFires(): Array<IntArray> {
    val fires = Array(r) { IntArray(c) { Int.MAX_VALUE } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    find('F').forEach { (i, j) ->
        fires[i][j] = 0
        queue.add(Pair(i, j))
    }

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] != '#' && fires[nextX][nextY] == Int.MAX_VALUE) {
                fires[nextX][nextY] = fires[x][y] + 1
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return fires
}

private fun find(char: Char): List<Pair<Int, Int>> {
    val pairs = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == char) {
                pairs.add(Pair(i, j))
            }
        }
    }
    return pairs
}

private fun isEscaped(x: Int, y: Int) =
    x == 0 || x == r - 1 || y == 0 || y == c - 1

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until r && y in 0 until c
