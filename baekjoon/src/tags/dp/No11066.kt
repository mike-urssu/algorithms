package tags.dp

/**
 * https://www.acmicpc.net/problem/11066
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val k = readln().toInt()
        val numbers = readln().split(" ").map { it.toInt() }
        println(getMinimumCost(k, numbers))
    }
}

private fun getMinimumCost(k: Int, numbers: List<Int>): Int {
    val prefixSum = numbers.runningFold(0, Int::plus)
    val dp = Array(k + 1) { IntArray(k + 1) }
    for (i in 1 until k) {
        for (a in 1..k - i) {
            val b = a + i
            dp[a][b] = Int.MAX_VALUE
            for (j in a until b) {
                dp[a][b] = dp[a][b].coerceAtMost(dp[a][j] + dp[j + 1][b] + prefixSum[b] - prefixSum[a - 1])
            }
        }
    }
    return dp[1][k]
}
