package tags.dp

/**
 * https://www.acmicpc.net/problem/12026
 */
fun main() {
    val n = readln().toInt()
    val s = readln()

    val chars = charArrayOf('B', 'O', 'J')
    val dp = IntArray(n) { Int.MAX_VALUE }
    dp[0] = 0
    (0 until n).forEach { i ->
        if (dp[i] != Int.MAX_VALUE) {
            val nextChar = chars[(chars.indexOf(s[i]) + 1) % 3]
            (i + 1 until n).forEach { j ->
                if (s[j] == nextChar) {
                    dp[j] = minOf(dp[j], dp[i] + (j - i) * (j - i))
                }
            }
        }
    }

    if (dp[n - 1] == Int.MAX_VALUE) {
        dp[n - 1] = -1
    }
    println(dp.last())
}
