package tags.bfs

/**
 * https://www.acmicpc.net/problem/14502
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>
private var max = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    setWalls(0)
    println(max)
}

private fun setWalls(walls: Int) {
    if (walls == 3) {
        val copiedGraph = Array(n) { i -> graph[i].copyOf() }
        spreadVirus(copiedGraph)
        val safetyArea = copiedGraph.sumOf { row -> row.count { it == 0 } }
        max = max.coerceAtLeast(safetyArea)
        return
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) {
                graph[i][j] = 1
                setWalls(walls + 1)
                graph[i][j] = 0
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun spreadVirus(graph: Array<IntArray>) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 2) {
                queue.add(Pair(i, j))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        for (i in 0 until 4) {
            val nextX = p.first + dx[i]
            val nextY = p.second + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
                graph[nextX][nextY] = 2
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
