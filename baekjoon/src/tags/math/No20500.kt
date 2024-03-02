package tags.math

/**
 * https://www.acmicpc.net/problem/20500
 */
private const val MOD = 1_000_000_007

fun main() {
    val n = readln().toInt()
    val dp = Array(3) { IntArray(1516) }
    dp[0][2] = 1
    dp[1][2] = 1
    for (j in 3..1515) {
        dp[0][j] = (dp[1][j - 1] + dp[2][j - 1]) % MOD
        dp[1][j] = (dp[2][j - 1] + dp[0][j - 1]) % MOD
        dp[2][j] = (dp[0][j - 1] + dp[1][j - 1]) % MOD
    }
    println(dp[0][n])
}
