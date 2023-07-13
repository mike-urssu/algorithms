package tags.dp

/**
 * https://www.acmicpc.net/problem/1309
 */
fun main() {
    val n = readln().toInt()
    val dp = Array(100001) { IntArray(3) }
    dp[1].fill(1)
    (2..100000).forEach { i ->
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901
    }
    println((dp[n].sum()) % 9901)
}
