package tags.dp

/**
 * https://www.acmicpc.net/problem/12865
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val weights = IntArray(n)
    val values = IntArray(n)
    repeat(n) { i ->
        val (weight, value) = readln().split(" ").map { it.toInt() }
        weights[i] = weight
        values[i] = value
    }
    val dp = getKnapsack(n, k, weights, values)
    println(dp.last().last())
}

private fun getKnapsack(n: Int, k: Int, weights: IntArray, values: IntArray): Array<IntArray> {
    val dp = Array(n + 1) { IntArray(k + 1) }
    (1..n).forEach { i ->
        (1..k).forEach { j ->
            dp[i][j] = if (j < weights[i - 1]) {
                dp[i - 1][j]
            } else {
                maxOf(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1])
            }
        }
    }
    return dp
}
