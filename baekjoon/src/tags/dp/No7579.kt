package tags.dp

/**
 * https://www.acmicpc.net/problem/7579
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val memories = IntArray(n + 1).apply { readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1) }
    val costs = IntArray(n + 1).apply { readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1) }
    println(getLeastCost(n, memories, costs, m))
}

private fun getLeastCost(n: Int, memories: IntArray, costs: IntArray, m: Int): Int {
    val dp = getDp(n, memories, costs)
    val totalCosts = costs.sum()
    for (j in 0..totalCosts) {
        for (i in 1..n) {
            if (dp[i][j] >= m) {
                return j
            }
        }
    }
    return -1
}

private fun getDp(n: Int, memories: IntArray, costs: IntArray): Array<IntArray> {
    val totalCosts = costs.sum()
    val dp = Array(n + 1) { IntArray(totalCosts + 1) }
    for (i in 1..n) {
        for (j in 0..totalCosts) {
            dp[i][j] = if (j < costs[i]) {
                dp[i - 1][j]
            } else {
                maxOf(dp[i - 1][j], dp[i - 1][j - costs[i]] + memories[i])
            }
        }
    }
    return dp
}
