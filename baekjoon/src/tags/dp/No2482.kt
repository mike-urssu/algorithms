package tags.dp

/**
 * https://www.acmicpc.net/problem/2482
 */
fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    println(count(n, k))
}

private const val p = 1_000_000_003

private fun count(n: Int, k: Int): Int {
    if (k == 1) {
        return n
    }

    val dp = Array(n + 1) { IntArray(k + 1) }
    (1..n).forEach { i ->
        dp[i][1] = i
        dp[i][0] = 1
    }
    (2..n).forEach { i ->
        (2..k).forEach { j ->
            dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % p
        }
    }
    return (dp[n - 3][k - 1] + dp[n - 1][k]) % p
}
