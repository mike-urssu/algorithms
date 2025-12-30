package tags.dp

/**
 * https://www.acmicpc.net/problem/1328
 */
fun main() {
    val (n, l, r) = readln().split(" ").map { it.toInt() }

    val mod = 1_000_000_007
    val dp = Array(n + 1) { Array(n + 1) { LongArray(n + 1) } }
    dp[1][1][1] = 1
    (2..n).forEach { i ->
        (1..l).forEach { j ->
            (1..r).forEach { k ->
                dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + dp[i - 1][j][k] * (i - 2)) % mod
            }
        }
    }
    println(dp[n][l][r])
}
