package tags.bfs

/**
 * https://www.acmicpc.net/problem/17141
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>
private lateinit var viruses: List<Pair<Int, Int>>
private lateinit var combination: IntArray
private var min = Int.MAX_VALUE

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    viruses = findViruses()
    combination = IntArray(m)
    setViruses(0, 0)

    if (min == Int.MAX_VALUE) {
        min = -1
    }
    println(min)
}

private fun findViruses(): List<Pair<Int, Int>> {
    val viruses = mutableListOf<Pair<Int, Int>>()
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] == 2) {
                viruses.add(i to j)
            }
        }
    }
    return viruses
}

private fun setViruses(index: Int, cIndex: Int) {
    if (index == m) {
        val time = spread()
        min = min.coerceAtMost(time)
        return
    }

    (cIndex until viruses.size).forEach { i ->
        combination[index] = i
        setViruses(index + 1, i + 1)
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun spread(): Int {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    val isVisited = Array(n) { BooleanArray(n) }
    combination.forEach { i ->
        val (x, y) = viruses[i]
        queue.add(Triple(x, y, 0))
        isVisited[x][y] = true
    }

    var max = 0
    while (queue.isNotEmpty()) {
        val (x, y, t) = queue.poll()
        max = max.coerceAtLeast(t)

        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] != 1) {
                queue.add(Triple(nextX, nextY, t + 1))
                isVisited[nextX][nextY] = true
            }
        }
    }

    return if (isValid(isVisited)) {
        max
    } else {
        Int.MAX_VALUE
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n

private fun isValid(isVisited: Array<BooleanArray>): Boolean {
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (!isVisited[i][j] && (graph[i][j] == 0 || graph[i][j] == 2)) {
                return false
            }
        }
    }
    return true
}
