package tags.dp

/**
 * https://www.acmicpc.net/problem/1562
 */
private const val MOD = 1_000_000_000

fun main() {
    val n = readln().toInt()
    val dp = getDp()
    val sum = (0..9).map { j -> dp[n][j][1023] }.fold(0) { acc, i -> (acc + i) % MOD }
    println(sum)
}

private fun getDp(): Array<Array<IntArray>> {
    val dp = Array(101) { Array(10) { IntArray(1024) } }
    (1..9).forEach { j -> dp[1][j][1 shl j] = 1 }
    (2..100).forEach { i ->
        (0..9).forEach { j ->
            (0 until (1 shl 10)).forEach { k ->
                val bit = k or (1 shl j)
                dp[i][j][bit] = when (j) {
                    0 -> (dp[i][0][bit] + dp[i - 1][1][k]) % MOD
                    9 -> (dp[i][9][bit] + dp[i - 1][8][k]) % MOD
                    else -> (dp[i][j][bit] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD
                }
            }
        }
    }
    return dp
}
