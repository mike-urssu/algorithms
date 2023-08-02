package tags.dp

/**
 * https://www.acmicpc.net/problem/2096
 */
fun main() {
    val n = readln().toInt()
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    println("${getMax(n, graph)} ${getMin(n, graph)}")
}

private fun getMax(n: Int, graph: Array<IntArray>): Int {
    val dp = Array(n) { IntArray(3) }
    dp[n - 1] = graph[n - 1].copyOf()
    for (i in n - 2 downTo 0) {
        dp[i][0] = graph[i][0] + maxOf(dp[i + 1][0], dp[i + 1][1])
        dp[i][1] = graph[i][1] + maxOf(dp[i + 1][0], dp[i + 1][1], dp[i + 1][2])
        dp[i][2] = graph[i][2] + maxOf(dp[i + 1][1], dp[i + 1][2])
    }
    return dp[0].max()
}

private fun getMin(n: Int, graph: Array<IntArray>): Int {
    val dp = Array(n) { IntArray(3) }
    dp[n - 1] = graph[n - 1].copyOf()
    for (i in n - 2 downTo 0) {
        dp[i][0] = graph[i][0] + minOf(dp[i + 1][0], dp[i + 1][1])
        dp[i][1] = graph[i][1] + minOf(dp[i + 1][0], dp[i + 1][1], dp[i + 1][2])
        dp[i][2] = graph[i][2] + minOf(dp[i + 1][1], dp[i + 1][2])
    }
    return dp[0].min()
}
