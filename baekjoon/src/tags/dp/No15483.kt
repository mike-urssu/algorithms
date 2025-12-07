package tags.dp

/**
 * https://www.acmicpc.net/problem/15483
 */
fun main() {
    val s1 = readln().toMutableList().apply { this.add(0, '#') }
    val s2 = readln().toMutableList().apply { this.add(0, '#') }

    val dp = Array(s1.size) { IntArray(s2.size) }
    s1.indices.forEach { i -> dp[i][0] = i }
    s2.indices.forEach { j -> dp[0][j] = j }
    for (i in 1 until s1.size) {
        for (j in 1 until s2.size) {
            dp[i][j] = if (s1[i] == s2[j]) {
                dp[i - 1][j - 1]
            } else {
                minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
            }
        }
    }
    println(dp.last().last())
}
