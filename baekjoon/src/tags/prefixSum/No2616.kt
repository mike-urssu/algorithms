package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/2616
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val length = readln().toInt()

    val prefixSum = numbers.runningFold(0, Int::plus)
    val dp = Array(4) { IntArray(n + 1) }
    (1..3).forEach { i ->
        (i * length until n + 1).forEach { j ->
            dp[i][j] = dp[i][j - 1].coerceAtLeast(dp[i - 1][j - length] + (prefixSum[j] - prefixSum[j - length]))
        }
    }
    println(dp.last().last())
}
