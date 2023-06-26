package tags.dp

/**
 * https://www.acmicpc.net/problem/9251
 */
fun main() {
    val s1 = readln()
    val s2 = readln()
    println(lcs("!$s1", "@$s2"))
}

private fun lcs(s1: String, s2: String): Int {
    val dp = Array(s1.length) { IntArray(s2.length) }
    for (i in 1 until s1.length) {
        for (j in 1 until s2.length) {
            dp[i][j] = if (s1[i] == s2[j]) {
                dp[i - 1][j - 1] + 1
            } else {
                maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp.last().last()
}
