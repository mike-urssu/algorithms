package tags.dp

/**
 * https://www.acmicpc.net/problem/4811
 */
fun main() {
    val dp = getDp()
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }
        println(dp[n])
    }
}

private fun getDp(): LongArray {
    val dp = LongArray(31)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    (3..30).forEach { i ->
        (0 until i).forEach { j ->
            dp[i] += dp[i - 1 - j] * dp[j]
        }
    }
    return dp
}
