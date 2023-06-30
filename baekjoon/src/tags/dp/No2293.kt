package tags.dp

/**
 * https://www.acmicpc.net/problem/2293
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val values = IntArray(n) { readln().toInt() }
    val dp = IntArray(k + 1)
    dp[0] = 1
    for (value in values) {
        for (j in value..k) {
            dp[j] += dp[j - value]
        }
    }
    println(dp.last())
}
