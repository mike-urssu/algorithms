package tags.bfs

/**
 * https://www.acmicpc.net/problem/2146
 */
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = getGraph()
    println(getLeastLength())
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getGraph(): Array<IntArray> {
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val isVisited = Array(n) { BooleanArray(n) }

    var land = 1
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 1 && !isVisited[i][j]) {
                setLand(graph, isVisited, i, j, land++)
            }
        }
    }

    return graph
}

private fun setLand(graph: Array<IntArray>, isVisited: Array<BooleanArray>, row: Int, col: Int, land: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    graph[row][col] = land
    isVisited[row][col] = true
    queue.add(Pair(row, col))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 1 && !isVisited[nextX][nextY]) {
                graph[nextX][nextY] = land
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun getLeastLength(): Int {
    var length = Int.MAX_VALUE
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] != 0 && isMovable(i, j)) {
                length = length.coerceAtMost(getLength(i, j, graph[i][j]))
            }
        }
    }
    return length
}

private fun isMovable(x: Int, y: Int): Boolean {
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
            return true
        }
    }
    return false
}

private fun getLength(row: Int, col: Int, land: Int): Int {
    var length = Int.MAX_VALUE
    val isVisited = Array(n) { BooleanArray(n) }
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }

    isVisited[row][col] = true
    queue.add(Triple(row, col, 0))

    while (queue.isNotEmpty()) {
        val (x, y, l) = queue.poll()
        if (graph[x][y] != 0 && graph[x][y] != land && l < length) {
            length = l
            break
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (
                isInBoundary(nextX, nextY)
                && graph[nextX][nextY] != land
                && !isVisited[nextX][nextY]
                && length > l + 1
            ) {
                isVisited[nextX][nextY] = true
                queue.add(Triple(nextX, nextY, l + 1))
            }
        }
    }

    return length - 1
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
