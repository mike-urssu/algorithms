package tags.bfs

/**
 * https://www.acmicpc.net/problem/1743
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private var k = 0

private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

private var max = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    k = input[2]
    graph = Array(n) { IntArray(m) }
    repeat(k) {
        val (r, c) = readln().split(" ").map { it.toInt() - 1 }
        graph[r][c] = 1
    }
    isVisited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j] && graph[i][j] == 1) {
                val count = bfs(i, j)
                max = max.coerceAtLeast(count)
            }
        }
    }

    println(max)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs(row: Int, col: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var count = 0

    isVisited[row][col] = true
    count++
    queue.add(Pair(row, col))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 1) {
                isVisited[nextX][nextY] = true
                count++
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return count
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
