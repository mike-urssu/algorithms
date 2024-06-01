package tags.bfs

/**
 * https://www.acmicpc.net/problem/14923
 */
import java.util.PriorityQueue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    val (hx, hy) = readln().split(" ").map { it.toInt() - 1 }
    val (ex, ey) = readln().split(" ").map { it.toInt() - 1 }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    println(getDistance(hx, hy, ex, ey))
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun getDistance(hx: Int, hy: Int, ex: Int, ey: Int): Int {
    var min = Int.MAX_VALUE
    val queue = PriorityQueue<IntArray> { it, other -> it[3].compareTo(other[3]) }
    val isVisited = Array(2) { Array(n) { BooleanArray(m) } }

    queue.add(intArrayOf(hx, hy, 0, 0))
    isVisited[0][hx][hy] = true

    while (queue.isNotEmpty()) {
        val (x, y, w, d) = queue.poll()
        if (x == ex && y == ey) {
            min = min.coerceAtMost(d)
            break
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY)) {
                if (w == 0) {
                    val t = graph[nextX][nextY]
                    if (!isVisited[t][nextX][nextY]) {
                        queue.add(intArrayOf(nextX, nextY, t, d + 1))
                        isVisited[t][nextX][nextY] = true
                    }
                } else {
                    if (graph[nextX][nextY] == 0 && !isVisited[1][nextX][nextY]) {
                        queue.add(intArrayOf(nextX, nextY, 1, d + 1))
                        isVisited[1][nextX][nextY] = true
                    }
                }
            }
        }
    }

    return if (min == Int.MAX_VALUE) {
        -1
    } else {
        min
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
