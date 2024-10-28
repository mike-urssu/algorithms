package tags.bfs

/**
 * https://www.acmicpc.net/problem/17836
 */
import java.util.PriorityQueue

private var n = 0
private var m = 0
private var t = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    t = input[2]
    graph = getGraph()
    val min = getMinTime()
    if (min > t) {
        println("Fail")
    } else {
        println(min)
    }
}

private fun getGraph(): Array<IntArray> {
    val graph = Array(n + 1) { IntArray(m + 1) }
    (1..n).forEach { i ->
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(graph[i], 1)
    }
    return graph
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun getMinTime(): Int {
    val queue = PriorityQueue<IntArray> { it, other -> -it[0].compareTo(other[0]) }
    val seconds = Array(2) { Array(n + 1) { IntArray(m + 1) { 1_000_000 } } }
    queue.add(intArrayOf(0, 1, 1))
    seconds[0][1][1] = 0

    while (queue.isNotEmpty()) {
        val (d, x, y) = queue.poll()
        val t = seconds[d][x][y]
        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY)) {
                if (d == 0) {
                    if (graph[nextX][nextY] == 0 && t + 1 < seconds[0][nextX][nextY]) {
                        seconds[0][nextX][nextY] = t + 1
                        queue.add(intArrayOf(0, nextX, nextY))
                    } else if (graph[nextX][nextY] == 2 && t + 1 <= seconds[0][nextX][nextY]) {
                        seconds[0][nextX][nextY] = t + 1
                        seconds[1][nextX][nextY] = t + 1
                        queue.add(intArrayOf(1, nextX, nextY))
                    }
                } else {
                    if (t + 1 < seconds[1][nextX][nextY]) {
                        seconds[1][nextX][nextY] = t + 1
                        queue.add(intArrayOf(1, nextX, nextY))
                    }
                }
            }
        }
    }

    return seconds[0][n][m].coerceAtMost(seconds[1][n][m])
}

private fun isInBoundary(x: Int, y: Int) =
    x in 1..n && y in 1..m
