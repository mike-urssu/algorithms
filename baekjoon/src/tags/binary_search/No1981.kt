package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1981
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    println(getMinGap())
}

private fun getMinGap(): Int {
    val max = graph.maxOf { it.max() }
    val min = graph.minOf { it.min() }

    var low = -1
    var high = max - min
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if ((min..max).any { i -> canPass(i..i + mid) }) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun canPass(range: IntRange): Boolean {
    if (graph[0][0] !in range) {
        return false
    }

    val isVisited = Array(n) { BooleanArray(n) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    isVisited[0][0] = true
    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        if (x == n - 1 && y == n - 1) {
            return true
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] in range) {
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return false
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
