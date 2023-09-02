package tags.bfs

/**
 * https://www.acmicpc.net/problem/2583
 */
import java.util.LinkedList
import java.util.Queue

private var m = 0
private var n = 0

private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    val k = input[2]
    graph = Array(m) { IntArray(n) }
    isVisited = Array(m) { BooleanArray(n) }
    repeat(k) {
        val (y1, x1, y2, x2) = readln().split(" ").map { it.toInt() }
        for (i in x1 until x2) {
            for (j in y1 until y2) {
                graph[i][j] = 1
            }
        }
    }

    val areas = mutableListOf<Int>()
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!isVisited[i][j] && graph[i][j] == 0) {
                val area = bfs(i, j)
                areas.add(area)
            }
        }
    }

    println(areas.size)
    println(areas.sorted().joinToString(" "))
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun bfs(row: Int, col: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var count = 1
    isVisited[row][col] = true
    queue.add(Pair(row, col))
    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0 && !isVisited[nextX][nextY]) {
                count++
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
    return count
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until m && y in 0 until n
