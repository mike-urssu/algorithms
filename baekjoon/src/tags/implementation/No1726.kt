package tags.implementation

/**
 * https://www.acmicpc.net/problem/1726
 */
import java.util.PriorityQueue

private var m = 0
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var visitedMap: MutableMap<Triple<Int, Int, Int>, Int>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    graph = getGraph()
    visitedMap = mutableMapOf()

    val (x1, y1, d1) = readln().split(" ").map { it.toInt() }
    val (x2, y2, d2) = readln().split(" ").map { it.toInt() }
    getMovement(x1, y1, d1, x2, y2, d2)

    println(visitedMap[Triple(x2, y2, d2)])
}

private fun getGraph(): Array<IntArray> {
    val graph = Array(m + 1) { IntArray(n + 1) }
    (1..m).forEach { i ->
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(graph[i], 1)
    }
    return graph
}

private val dx = intArrayOf(0, 0, 0, 1, -1)
private val dy = intArrayOf(0, 1, -1, 0, 0)

private fun getMovement(x1: Int, y1: Int, d1: Int, x2: Int, y2: Int, d2: Int) {
    val queue = PriorityQueue<IntArray> { it, other -> it[3].compareTo(other[3]) }
    queue.add(intArrayOf(x1, y1, d1, 0))
    visitedMap[Triple(x1, y1, d1)] = 0

    val inc = intArrayOf(0, 1, 2, 1)
    while (queue.isNotEmpty()) {
        val (x, y, d, c) = queue.poll()

        if (x == x2 && y == y2 && d == d2) {
            visitedMap[Triple(x, y, d)] = minOf((visitedMap[Triple(x, y, d)] ?: Int.MAX_VALUE), c)
            continue
        }

        (1..3).forEach { k ->
            val nextX = x + dx[d] * k
            val nextY = y + dy[d] * k
            if (canGo(x, y, d, k) && (visitedMap[Triple(nextX, nextY, d)] ?: Int.MAX_VALUE) > c + 1) {
                queue.add(intArrayOf(nextX, nextY, d, c + 1))
                visitedMap[Triple(nextX, nextY, d)] = minOf(visitedMap[Triple(nextX, nextY, d)] ?: Int.MAX_VALUE, c + 1)
            }
        }

        var nextD = d
        (1..3).forEach { l ->
            nextD = rotateClockwise(nextD)
            if ((visitedMap[Triple(x, y, nextD)] ?: Int.MAX_VALUE) > c + inc[l]) {
                queue.add(intArrayOf(x, y, nextD, c + inc[l]))
                visitedMap[Triple(x, y, nextD)] = minOf(visitedMap[Triple(x, y, nextD)] ?: Int.MAX_VALUE, c + inc[l])
            }
        }
    }
}

private fun canGo(x: Int, y: Int, d: Int, k: Int): Boolean {
    return (1..k).all { i ->
        val nextX = x + dx[d] * i
        val nextY = y + dy[d] * i
        isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 1..m && y in 1..n

private fun rotateClockwise(d: Int): Int {
    return when (d) {
        1 -> 3
        2 -> 4
        3 -> 2
        else -> 1
    }
}
