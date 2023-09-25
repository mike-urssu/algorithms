package tags.bfs

/**
 * https://www.acmicpc.net/problem/1926
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val areas = getAreas()
    println(areas.size)
    println(areas.maxOrNull() ?: 0)
}

private fun getAreas(): List<Int> {
    val areas = mutableListOf<Int>()
    val isVisited = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1 && !isVisited[i][j]) {
                areas.add(getArea(isVisited, i, j))
            }
        }
    }
    return areas
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getArea(isVisited: Array<BooleanArray>, row: Int, col: Int): Int {
    var area = 1
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    isVisited[row][col] = true
    queue.add(Pair(row, col))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 1 && !isVisited[nextX][nextY]) {
                area++
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return area
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
