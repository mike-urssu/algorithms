package tags.dp

/**
 * https://www.acmicpc.net/problem/1915
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    val length = getLength(n, m)
    println(length * length)
}

private fun getGraph(n: Int, m: Int): Array<IntArray> {
    val graph = Array(n + 1) { IntArray(m + 1) }
    repeat(n) { i ->
        graph[i + 1] = readln().map { it.digitToInt() }.toIntArray().copyInto(graph[i + 1], 1)
    }
    return graph
}

private fun getLength(n: Int, m: Int): Int {
    val dp = Array(n + 1) { graph[it].copyOf() }
    for (i in 1..n) {
        for (j in 1..m) {
            dp[i][j] = if (graph[i][j] == 1) {
                minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
            } else {
                0
            }
        }
    }
    return dp.maxOf { it.max() }
}
