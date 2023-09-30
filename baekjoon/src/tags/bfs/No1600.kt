package tags.bfs

/**
 * https://www.acmicpc.net/problem/1600
 */
import java.util.PriorityQueue

private var w = 0
private var h = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val k = readln().toInt()
    val input = readln().split(" ").map { it.toInt() }
    w = input[0]
    h = input[1]
    graph = Array(h) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val action = getLeastAction(k)
    if (action == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(action)
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private val ddx = intArrayOf(-2, -2, -1, 1, 2, 2, 1, -1)
private val ddy = intArrayOf(-1, 1, 2, 2, 1, -1, -2, -2)

private fun getLeastAction(k: Int): Int {
    val counts = Array(k + 1) { Array(h) { IntArray(w) { Int.MAX_VALUE } } }
    val queue = PriorityQueue<IntArray> { it, other -> it[3].compareTo(other[3]) }

    counts[0][0][0] = 0
    queue.add(intArrayOf(0, 0, 0, 0))

    while (queue.isNotEmpty()) {
        val (h, x, y, c) = queue.poll()
        if (counts[h][x][y] < c) {
            continue
        }

        if (h < k) {
            for (i in 0 until 8) {
                val nextX = x + ddx[i]
                val nextY = y + ddy[i]
                if (
                    isInBoundary(nextX, nextY)
                    && graph[nextX][nextY] == 0
                    && counts[h + 1][nextX][nextY] > c + 1
                ) {
                    counts[h + 1][nextX][nextY] = c + 1
                    queue.add(intArrayOf(h + 1, nextX, nextY, c + 1))
                }
            }
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (
                isInBoundary(nextX, nextY)
                && graph[nextX][nextY] == 0
                && counts[h][nextX][nextY] > c + 1
            ) {
                counts[h][nextX][nextY] = c + 1
                queue.add(intArrayOf(h, nextX, nextY, c + 1))
            }
        }
    }

    return counts.minOf { it.last().last() }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until h && y in 0 until w
