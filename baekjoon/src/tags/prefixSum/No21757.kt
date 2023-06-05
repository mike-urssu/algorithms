package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/21757
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val prefixSum = numbers.runningFold(0, Long::plus)
    if (prefixSum.last() % 4 != 0L) {
        println(0)
    } else if (prefixSum.last() == 0L) {
        val zeros = prefixSum.count { it == 0L } - 1L
        println((zeros - 1) * (zeros - 2) * (zeros - 3) / 6)
    } else {
        val quarter = prefixSum.last() / 4
        val dp = Array(n + 1) { LongArray(4) }
        dp[0][0] = 1
        for (i in 1..n) {
            dp[i][0] = 1
            for (j in 1..3) {
                dp[i][j] = dp[i - 1][j]
                if (prefixSum[i] == quarter * j) {
                    dp[i][j] += dp[i - 1][j - 1]
                }
            }
        }
        println(dp.last().last())
    }
}
