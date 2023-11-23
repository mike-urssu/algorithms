package tags.dp

/**
 * https://www.acmicpc.net/problem/1958
 */
fun main() {
    val s1 = "!" + readln()
    val s2 = "@" + readln()
    val s3 = "#" + readln()
    println(getLCS(s1, s2, s3))
}

private fun getLCS(s1: String, s2: String, s3: String): Int {
    val dp = Array(s1.length) { Array(s2.length) { IntArray(s3.length) } }
    for (i in 1 until s1.length) {
        for (j in 1 until s2.length) {
            for (k in 1 until s3.length) {
                dp[i][j][k] = if (s1[i] == s2[j] && s2[j] == s3[k]) {
                    dp[i - 1][j - 1][k - 1] + 1
                } else {
                    maxOf(dp[i - 1][j][k], dp[i][j - 1][k], dp[i][j][k - 1])
                }
            }
        }
    }
    return dp.last().last().last()
}
