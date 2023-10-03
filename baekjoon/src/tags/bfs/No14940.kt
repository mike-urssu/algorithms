package tags.bfs

/**
 * https://www.acmicpc.net/problem/14940
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

    val distances = getDistances()
    val map = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) {
                map.append("0 ")
            } else {
                if (distances[i][j] == Int.MAX_VALUE) {
                    map.append("-1 ")
                } else {
                    map.append("${distances[i][j]} ")
                }
            }
        }
        map.append('\n')
    }
    println(map)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getDistances(): Array<IntArray> {
    val src = findSrc()
    val distances = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    distances[src.first][src.second] = 0
    queue.add(src)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (
                isInBoundary(nextX, nextY)
                && graph[nextX][nextY] == 1
                && distances[nextX][nextY] > distances[x][y] + 1
            ) {
                distances[nextX][nextY] = distances[x][y] + 1
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return distances
}

private fun findSrc(): Pair<Int, Int> {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 2) {
                return Pair(i, j)
            }
        }
    }
    return Pair(-1, -1)
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
