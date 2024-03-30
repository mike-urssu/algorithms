package tags.bfs

/**
 * https://www.acmicpc.net/problem/14442
 */
import java.util.PriorityQueue

private var n = 0
private var m = 0
private var k = 0

private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<Array<BooleanArray>>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    k = input[2]

    graph = Array(n) { readln().map { it.digitToInt() }.toIntArray() }
    isVisited = Array(k + 1) { Array(n) { BooleanArray(m) } }

    val max = bfs()
    if (max == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(max)
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun bfs(): Int {
    val queue = PriorityQueue<IntArray> { it, other -> it[2].compareTo(other[2]) }
    queue.add(intArrayOf(0, 0, 1, 0))

    while (queue.isNotEmpty()) {
        val (x, y, d, w) = queue.poll()
        if (x == n - 1 && y == m - 1) {
            return d
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY)) {
                if (graph[nextX][nextY] == 0 && !isVisited[w][nextX][nextY]) {
                    isVisited[w][nextX][nextY] = true
                    queue.add(intArrayOf(nextX, nextY, d + 1, w))
                }

                if (graph[nextX][nextY] == 1 && w < k && !isVisited[w + 1][nextX][nextY]) {
                    isVisited[w + 1][nextX][nextY] = true
                    queue.add(intArrayOf(nextX, nextY, d + 1, w + 1))
                }
            }
        }
    }

    return -1
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
