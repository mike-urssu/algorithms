package tags.dp

/**
 * https://www.acmicpc.net/problem/2688
 */
fun main() {
    val dp = dp()
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val sum = (0..9).sumOf { dp[it][n] }
        println(sum)
    }
}

private fun dp(): Array<LongArray> {
    val dp = Array(10) { LongArray(65) }
    (0..9).forEach { i -> dp[i][1] = 1 }
    (2..64).forEach { j ->
        (0..9).forEach { i ->
            dp[i][j] = (0..i).sumOf { dp[it][j - 1] }
        }
    }
    return dp
}
