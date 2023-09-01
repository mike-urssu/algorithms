package tags.bfs

/**
 * https://www.acmicpc.net/problem/2468
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

private var max = 1

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    while (true) {
        if (graph.all { row -> row.all { it == 0 } }) {
            break
        }
        isVisited = Array(n) { BooleanArray(n) }
        sink()
        val count = countSafetyAreas()
        max = max.coerceAtLeast(count)
    }
    println(max)
}

private fun sink() {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] > 0) {
                graph[i][j]--
            }
        }
    }
}

private fun countSafetyAreas(): Int {
    var count = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] > 0 && !isVisited[i][j]) {
                bfs(i, j)
                count++
            }
        }
    }
    return count
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs(row: Int, col: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(row, col))
    isVisited[row][col] = true

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] > 0 && !isVisited[nextX][nextY]) {
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
