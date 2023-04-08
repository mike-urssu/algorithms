package tags.dfs

/**
 * https://www.acmicpc.net/problem/1520
 */
private lateinit var graph: Array<IntArray>
private lateinit var dp: Array<IntArray>

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    graph = Array(m) { readln().split(" ").map { it.toInt() }.toIntArray() }
    dp = Array(m) { IntArray(n) { -1 } }

    dfs(0, 0)

    println(dp.first().first())
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private fun dfs(x: Int, y: Int): Int {
    if (x == graph.size - 1 && y == graph[x].size - 1) {
        return 1
    }

    if (dp[x][y] != -1) {
        return dp[x][y]
    }

    dp[x][y] = 0
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] < graph[x][y]) {
            dp[x][y] += dfs(nextX, nextY)
        }
    }

    return dp[x][y]
}

private fun isInBoundary(x: Int, y: Int) = x in graph.indices && y in graph.first().indices
