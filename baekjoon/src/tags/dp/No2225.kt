package tags.dp

/**
 * https://www.acmicpc.net/problem/2225
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val dp = Array(201) { IntArray(201) }
    (1..200).forEach { i ->
        (1..200).forEach { j ->
            dp[i][j] = if (i == 1) {
                j
            } else {
                (dp[i - 1][j] + dp[i][j - 1]) % 1000000000
            }
        }
    }
    println(dp[n][k])
}
