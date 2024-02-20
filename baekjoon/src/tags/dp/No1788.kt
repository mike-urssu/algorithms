package tags.dp

/**
 * https://www.acmicpc.net/problem/1788
 */
import kotlin.math.abs
import kotlin.math.sign

fun main() {
    val n = readln().toInt()
    val fibonacci = dp()[n + 1_000_000]
    println(fibonacci.sign)
    println(abs(fibonacci))
}

private const val MOD = 1_000_000_000

private fun dp(): LongArray {
    val dp = LongArray(2_000_001)
    dp[1_000_000] = 0
    dp[1_000_001] = 1
    (1_000_002..2_000_000).forEach { i -> dp[i] = (dp[i - 2] + dp[i - 1]) % MOD }
    (1_000_000 downTo 0).forEach { i -> dp[i] = (dp[i + 2] - dp[i + 1]) % MOD }
    return dp
}
