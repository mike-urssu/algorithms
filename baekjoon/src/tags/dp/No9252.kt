package tags.dp

/**
 * https://www.acmicpc.net/problem/9252
 */
fun main() {
    val s1 = readln()
    val s2 = readln()
    val lcs = StringBuilder()
    val dp = lcs("!$s1", "@$s2", lcs)
    val lcsLength = dp.last().last()
    println(lcsLength)
    if (lcsLength != 0) {
        println(getLCS("!$s1", "@$s2", dp))
    }
}

private fun lcs(s1: String, s2: String, lcs: StringBuilder): Array<IntArray> {
    val dp = Array(s1.length) { IntArray(s2.length) }
    (1 until s1.length).forEach { i ->
        (1 until s2.length).forEach { j ->
            dp[i][j] = if (s1[i] == s2[j]) {
                lcs.append(s1[i])
                dp[i - 1][j - 1] + 1
            } else {
                dp[i - 1][j].coerceAtLeast(dp[i][j - 1])
            }
        }
    }
    return dp
}

private fun getLCS(s1: String, s2: String, dp: Array<IntArray>): String {
    val lcs = StringBuilder()
    var i = s1.lastIndex
    var j = s2.lastIndex
    while (dp[i][j] != 0) {
        if (s1[i] == s2[j]) {
            lcs.append(s1[i])
            i--
            j--
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--
            } else {
                j--
            }
        }
    }
    return lcs.reverse().toString()
}
