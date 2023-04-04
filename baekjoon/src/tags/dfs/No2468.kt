package tags.dfs

/**
 * https://www.acmicpc.net/problem/2468
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var max = 0

fun main() {
    val n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val maxHeight = graph.maxOf { it.max() }

    for (h in 0 until maxHeight) {
        isVisited = Array(n) { BooleanArray(n) }
        var count = 0
        for (i in graph.indices) {
            for (j in graph[i].indices) {
                if (!isVisited[i][j] && graph[i][j] > h) {
                    dfs(i, j, h)
                    count++
                }
            }
        }
        max = max.coerceAtLeast(count)
    }

    println(max)
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int, h: Int) {
    isVisited[x][y] = true
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] > h) {
            dfs(nextX, nextY, h)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph[x].indices
