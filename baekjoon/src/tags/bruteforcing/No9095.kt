package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/9095
 */
fun main() {
    val dp = getDp()

    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(dp[n])
    }
}

private fun getDp(): IntArray {
    val dp = IntArray(11)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    (4..10).forEach { i -> dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1] }
    return dp
}
