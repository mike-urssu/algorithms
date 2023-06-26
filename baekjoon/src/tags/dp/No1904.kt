package tags.dp

/**
 * https://www.acmicpc.net/problem/1904
 */
fun main() {
    val dp = IntArray(1000001)
    dp[1] = 1
    dp[2] = 2
    (3..1000000).forEach { i -> dp[i] = (dp[i - 2] + dp[i - 1]) % 15746 }
    val n = readln().toInt()
    println(dp[n])
}
