package tags.dp

/**
 * https://www.acmicpc.net/problem/17070
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var dp: Array<Array<IntArray>>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    dp = getDp(n)
    println(dp[n - 1][n - 1].sum())
}

private fun getDp(n: Int): Array<Array<IntArray>> {
    val dp = Array(n) { Array(n) { IntArray(3) } }
    dp[0][1][0] = 1
    for (i in 0 until n) {
        for (j in 2 until n) {
            if (graph[i][j] == 1) {
                continue
            }
            dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
            if (i == 0) {
                continue
            }
            dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
            if (graph[i - 1][j] == 1 || graph[i][j - 1] == 1) {
                continue
            }
            dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
        }
    }
    return dp
}
