package tags.dp

/**
 * https://www.acmicpc.net/problem/15988
 */
fun main() {
    val dp = getDp()
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(dp[n])
    }
}

private fun getDp(): LongArray {
    val dp = LongArray(1000001)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    (4..1000000).forEach { i ->
        dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009
    }
    return dp
}
