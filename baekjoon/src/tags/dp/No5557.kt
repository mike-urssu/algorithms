package tags.dp

/**
 * https://www.acmicpc.net/problem/5557
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getDp(n, numbers).last()[numbers[n - 1]])
}

private fun getDp(n: Int, numbers: IntArray): Array<LongArray> {
    val dp = Array(n - 1) { LongArray(21) }
    dp[0][numbers[0]] = 1
    for (i in 1 until n - 1) {
        for (j in 0..20) {
            if (j + numbers[i] in 0..20) {
                dp[i][j] += dp[i - 1][j + numbers[i]]
            }
            if (j - numbers[i] in 0..20) {
                dp[i][j] += dp[i - 1][j - numbers[i]]
            }
        }
    }
    return dp
}
