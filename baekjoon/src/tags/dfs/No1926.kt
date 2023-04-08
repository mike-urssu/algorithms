package tags.dfs

/**
 * https://www.acmicpc.net/problem/1926
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var max = 0
private var area = 0

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    isVisited = Array(n) { BooleanArray(m) }

    var count = 0
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!isVisited[i][j] && graph[i][j] == 1) {
                area = 0
                dfs(i, j)
                count++
            }
        }
    }

    println(count)
    println(max)
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int) {
    isVisited[x][y] = true
    area++
    max = max.coerceAtLeast(area)

    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == 1) {
            dfs(nextX, nextY)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph.first().indices
