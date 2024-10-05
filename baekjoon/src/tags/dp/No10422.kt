package tags.dp

/**
 * https://www.acmicpc.net/problem/10422
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
    val dp = LongArray(5001)
    dp[0] = 1
    dp[2] = 1
    (4..5000 step 2).forEach { i ->
        (0 until i step 2).forEach { j ->
            dp[i] = (dp[i] + dp[j] * dp[i - j - 2]) % 1_000_000_007
        }
    }
    return dp
}
