package tags.dp

/**
 * https://www.acmicpc.net/problem/11060
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(countJump(n, numbers))
}

private fun countJump(n: Int, numbers: IntArray): Int {
    val dp = IntArray(n) { -1 }
    dp[0] = 0
    for (i in 0 until n) {
        if (dp[i] == -1) {
            continue
        }
        for (j in 1..numbers[i]) {
            if (i + j >= n) {
                break
            }
            dp[i + j] = if (dp[i + j] == -1) {
                dp[i] + 1
            } else {
                dp[i + j].coerceAtMost(dp[i] + 1)
            }
        }
    }
    return dp.last()
}
