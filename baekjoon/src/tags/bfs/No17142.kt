package tags.bfs

/**
 * https://www.acmicpc.net/problem/17142
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var viruses: List<Pair<Int, Int>>
private lateinit var activatedViruses: IntArray
private var min = Int.MAX_VALUE

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    val m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    viruses = find()
    activatedViruses = IntArray(m)
    for (i in viruses.indices) {
        combination(viruses.size, m - 1, 0, i)
    }

    if (min == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(min)
    }
}

private fun find(): List<Pair<Int, Int>> {
    val viruses = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 2) {
                viruses.add(Pair(i, j))
            }
        }
    }
    return viruses
}

private fun combination(n: Int, r: Int, index: Int, value: Int) {
    activatedViruses[index] = value
    if (index == r) {
        min = min.coerceAtMost(getTime())
        return
    }

    for (i in value + 1 until n) {
        combination(n, r, index + 1, i)
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getTime(): Int {
    val times = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    activatedViruses.forEach { i ->
        val (x, y) = viruses[i]
        times[x][y] = 0
        queue.add(Pair(x, y))
    }

    while (queue.isNotEmpty()) {
        if (canEscape(times)) {
            break
        }

        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (isInBoundary(nextX, nextY)) {
                if (graph[nextX][nextY] == 0 && times[nextX][nextY] > times[x][y] + 1) {
                    times[nextX][nextY] = times[x][y] + 1
                    queue.add(Pair(nextX, nextY))
                } else if (graph[nextX][nextY] == 2 && times[nextX][nextY] > times[x][y] + 1) {
                    times[nextX][nextY] = times[x][y] + 1
                    queue.add(Pair(nextX, nextY))
                }
            }
        }
    }

    return getMax(times)
}

private fun canEscape(times: Array<IntArray>): Boolean {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 0 && times[i][j] == Int.MAX_VALUE) {
                return false
            }
        }
    }
    return true
}

private fun getMax(times: Array<IntArray>): Int {
    var max = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 0 && times[i][j] == Int.MAX_VALUE) {
                return Int.MAX_VALUE
            }
            if (times[i][j] != Int.MAX_VALUE) {
                max = max.coerceAtLeast(times[i][j])
            }
        }
    }
    return max
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
