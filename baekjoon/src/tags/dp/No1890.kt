package tags.dp

/**
 * https://www.acmicpc.net/problem/1890
 */
private lateinit var graph: Array<IntArray>
private var n = 0

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val dp = getDp(n)
    println(dp[0][0])
}

private fun getDp(n: Int): Array<LongArray> {
    val dp = Array(n) { LongArray(n) }
    dp[n - 1][n - 1] = 1

    for (i in n - 1 downTo 0) {
        for (j in n - 1 downTo 0) {
            if (i == n - 1 && j == n - 1) {
                continue
            }

            val nextRow = graph[i][j] + i
            val nextCol = graph[i][j] + j

            val right = if (isInBoundary(i, nextCol)) {
                dp[i][nextCol]
            } else {
                0
            }
            val down = if (isInBoundary(nextRow, j)) {
                dp[nextRow][j]
            } else {
                0
            }

            dp[i][j] = right + down
        }
    }
    return dp
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
