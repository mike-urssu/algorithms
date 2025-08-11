package tags.dp

/**
 * https://www.acmicpc.net/problem/19947
 */
fun main() {
    val (h, y) = readln().split(" ").map { it.toInt() }

    val dp = Array(3) { IntArray(11) }
    dp[0][0] = h
    (1..10).forEach { j -> dp[0][j] = (dp[0][j - 1] * 1.05).toInt() }
    (0..10).forEach { j -> dp[1][j] = dp[0][j] }
    (3..10).forEach { j ->
        dp[1][j] = maxOf(
            dp[1][j],
            (dp[1][j - 1] * 1.05).toInt(),
            (dp[1][j - 3] * 1.20).toInt()
        )
    }
    (0..10).forEach { j -> dp[2][j] = dp[1][j] }
    (5..10).forEach { j ->
        dp[2][j] = maxOf(
            dp[2][j],
            (dp[2][j - 1] * 1.05).toInt(),
            (dp[2][j - 3] * 1.20).toInt(),
            (dp[2][j - 5] * 1.35).toInt()
        )
    }

    println(dp[2][y])
}
