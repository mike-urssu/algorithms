package tags.dp

/**
 * https://www.acmicpc.net/problem/25418
 */
fun main() {
    val (a, k) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(1_000_001)
    (a until k).forEach { i ->
        if (dp[i + 1] == 0) {
            dp[i + 1] = dp[i] + 1
        }
        if (i * 2 <= 1_000_000 && dp[i * 2] == 0) {
            dp[i * 2] = dp[i] + 1
        }
    }
    println(dp[k])
}
