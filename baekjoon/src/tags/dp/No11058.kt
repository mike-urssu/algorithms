package tags.dp

/**
 * https://www.acmicpc.net/problem/11058
 */
fun main() {
    val n = readln().toInt()
    println(dp()[n])
}

private fun dp(): LongArray {
    val dp = LongArray(101)
    (1..100).forEach { i ->
        dp[i] = dp[i - 1] + 1
        (3 until i).forEach { j ->
            dp[i] = dp[i].coerceAtLeast(dp[i - j] * (j - 1))
        }
    }
    return dp
}
