package tags.dp

/**
 * https://www.acmicpc.net/problem/2240
 */
fun main() {
    val (t, w) = readln().split(" ").map { it.toInt() }
    val numbers = IntArray(t + 1).apply {
        (1..t).forEach { i -> this[i] = readln().toInt() }
    }
    println(max(t, w, numbers))
}

private fun max(t: Int, w: Int, numbers: IntArray): Int {
    val dp = Array(3) { Array(t + 1) { IntArray(w + 2) } }
    (1..t).forEach { j ->
        (1..w + 1).forEach { k ->
            if (numbers[j] == 1) {
                dp[1][j][k] = dp[1][j - 1][k].coerceAtLeast(dp[2][j - 1][k - 1]) + 1
                dp[2][j][k] = dp[1][j - 1][k - 1].coerceAtLeast(dp[2][j - 1][k])
            } else {
                if (j != 1 || k != 1) {
                    dp[1][j][k] = dp[1][j - 1][k].coerceAtLeast(dp[2][j - 1][k - 1])
                    dp[2][j][k] = dp[1][j - 1][k - 1].coerceAtLeast(dp[2][j - 1][k]) + 1
                }
            }
        }
    }
    return (1..w + 1).maxOf { k -> dp[1][t][k].coerceAtLeast(dp[2][t][k]) }
}
