package tags.dp

/**
 * https://www.acmicpc.net/problem/2294
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val values = IntArray(n) { readln().toInt() }

    val dp = IntArray(k + 1) { 10001 }
    dp[0] = 0
    values.forEach { value ->
        (value..k).forEach { j ->
            dp[j] = dp[j].coerceAtMost(dp[j - value] + 1)
        }
    }

    if (dp.last() == 10001) {
        println(-1)
    } else {
        println(dp.last())
    }
}
