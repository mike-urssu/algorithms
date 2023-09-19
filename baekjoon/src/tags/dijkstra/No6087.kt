package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/6087
 */
import java.util.PriorityQueue

private var w = 0
private var h = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    w = input[0]
    h = input[1]
    graph = Array(h) { readln().toCharArray() }

    val (src, dst) = findCs()
    println(getLeastMirrors(src, dst))
}

private fun findCs(): List<Pair<Int, Int>> {
    val cs = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (graph[i][j] == 'C') {
                cs.add(Pair(i, j))
            }
        }
    }
    return cs
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getLeastMirrors(src: Pair<Int, Int>, dst: Pair<Int, Int>): Int {
    val mirrors = Array(h) { IntArray(w) { Int.MAX_VALUE } }
    val isVisited = Array(h) { Array(w) { IntArray(4) { Int.MAX_VALUE } } }
    val queue = PriorityQueue<IntArray> { it, other -> it[3].compareTo(other[3]) }

    mirrors[src.first][src.second] = 0
    (0 until 4).forEach { direction ->
        isVisited[src.first][src.second][direction] = 0
        queue.add(intArrayOf(src.first, src.second, direction, 0))
    }

    while (queue.isNotEmpty()) {
        val (x, y, direction, mirror) = queue.poll()
        if (x == dst.first && y == dst.second) {
            break
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] != '*') {
                if (direction == i) {
                    if (mirrors[nextX][nextY] >= mirror && isVisited[nextX][nextY][i] > mirror) {
                        mirrors[nextX][nextY] = mirror
                        isVisited[nextX][nextY][i] = mirror
                        queue.add(intArrayOf(nextX, nextY, i, mirrors[nextX][nextY]))
                    }
                } else {
                    if (mirrors[nextX][nextY] >= mirror + 1 && isVisited[nextX][nextY][i] > mirror + 1) {
                        mirrors[nextX][nextY] = mirror + 1
                        isVisited[nextX][nextY][i] = mirror + 1
                        queue.add(intArrayOf(nextX, nextY, i, mirrors[nextX][nextY]))
                    }
                }
            }
        }
    }

    return mirrors[dst.first][dst.second]
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until h && y in 0 until w
