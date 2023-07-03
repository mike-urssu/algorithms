package tags.dp

/**
 * https://www.acmicpc.net/problem/2133
 */
fun main() {
    val n = readln().toInt()
    val dp = IntArray(31)
    dp[0] = 1
    dp[2] = 3
    (4..30).forEach { i ->
        dp[i] = dp[i - 2] * 3
        (4..i step 2).forEach { j ->
            dp[i] += dp[i - j] * 2
        }
    }
    println(dp[n])
}
