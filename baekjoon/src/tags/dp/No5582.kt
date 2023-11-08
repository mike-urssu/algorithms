package tags.dp

/**
 * https://www.acmicpc.net/problem/5582
 */
fun main() {
    val s1 = "@${readln()}"
    val s2 = "#${readln()}"
    println(getLCS(s1, s2))
}

private fun getLCS(s1: String, s2: String): Int {
    var lcs = 0
    val dp = Array(s1.length) { IntArray(s2.length) }
    for (i in 1 until s1.length) {
        for (j in 1 until s2.length) {
            if (s1[i] == s2[j]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                lcs = lcs.coerceAtLeast(dp[i][j])
            }
        }
    }
    return lcs
}
