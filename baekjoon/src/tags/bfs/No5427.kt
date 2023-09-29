package tags.bfs

/**
 * https://www.acmicpc.net/problem/5427
 */
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

private var w = 0
private var h = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln().split(" ").map { it.toInt() }
        w = input[0]
        h = input[1]
        graph = Array(h) { readln().toCharArray() }

        val time = getTimeToEscape()
        if (time == Int.MAX_VALUE) {
            println("IMPOSSIBLE")
        } else {
            println(time)
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getTimeToEscape(): Int {
    val fires = getFires()
    val src = find('@')[0]
    val times = Array(h) { IntArray(w) { Int.MAX_VALUE } }
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }

    times[src.first][src.second] = 0
    queue.add(Triple(src.first, src.second, 0))

    while (queue.isNotEmpty()) {
        val (x, y, t) = queue.poll()
        if (canEscape(x, y)) {
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
                queue.add(Triple(nextX, nextY, times[nextX][nextY]))
            }
        }
    }

    return Int.MAX_VALUE
}

private fun getFires(): Array<IntArray> {
    val fires = Array(h) { IntArray(w) { Int.MAX_VALUE } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    find('*').forEach {
        fires[it.first][it.second] = 0
        queue.add(it)
    }

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] != '#' && fires[nextX][nextY] > fires[x][y] + 1) {
                fires[nextX][nextY] = fires[x][y] + 1
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return fires
}

private fun find(char: Char): List<Pair<Int, Int>> {
    val pairs = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (graph[i][j] == char) {
                pairs.add(Pair(i, j))
            }
        }
    }
    return pairs
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until h && y in 0 until w

private fun canEscape(x: Int, y: Int) =
    x == 0 || x == h - 1 || y == 0 || y == w - 1
