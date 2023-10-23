package tags.dp

/**
 * https://www.acmicpc.net/problem/1965
 */
fun main() {
    val n = readln().toInt()
    val sizes = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getMax(n, sizes))
}

private fun getMax(n: Int, sizes: IntArray): Int {
    val dp = IntArray(n) { 1 }
    dp[0] = 1
    (1 until n).forEach { i ->
        for (j in i - 1 downTo 0) {
            if (sizes[i] > sizes[j]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
        }
    }
    return dp.max()
}
