package tags.dp

/**
 * https://www.acmicpc.net/problem/1937
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var dp: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    dp = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (dp[i][j] == 0) {
                move(i, j)
            }
        }
    }

    println(dp.maxOf { it.max() })
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun move(x: Int, y: Int): Int {
    dp[x][y] = 1
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[x][y] > graph[nextX][nextY]) {
            if (dp[nextX][nextY] == 0) {
                move(nextX, nextY)
            }
            dp[x][y] = dp[x][y].coerceAtLeast(dp[nextX][nextY] + 1)
        }
    }
    return dp[x][y]
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
