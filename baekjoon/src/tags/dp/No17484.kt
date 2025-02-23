package tags.dp

/**
 * https://www.acmicpc.net/problem/17484
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(3) { Array(n) { IntArray(m) { 1_000_000 } } }
    (0 until 3).forEach { dp[it][0] = graph[0] }
    (1 until n).forEach { i ->
        (0 until m - 1).forEach { j ->
            dp[0][i][j] = minOf(dp[1][i - 1][j + 1], dp[2][i - 1][j + 1]) + graph[i][j]
        }
        (0 until m).forEach { j ->
            dp[1][i][j] = minOf(dp[0][i - 1][j + 0], dp[2][i - 1][j + 0]) + graph[i][j]
        }
        (1 until m).forEach { j ->
            dp[2][i][j] = minOf(dp[0][i - 1][j - 1], dp[1][i - 1][j - 1]) + graph[i][j]
        }
    }

    println((0 until 3).minOf { dp[it].last().min() })
}
