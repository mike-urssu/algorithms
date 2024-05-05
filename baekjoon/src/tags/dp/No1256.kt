package tags.dp

/**
 * https://www.acmicpc.net/problem/1256
 */
fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    println(getKthWord(n, m, k))
}

private fun getKthWord(n: Int, m: Int, k: Int): String {
    val dp = getDp()
    if (dp[n][m] < k) {
        return "-1"
    }

    var a = n
    var z = m
    var v = k
    val word = StringBuilder()
    repeat(n + m) {
        if (a == 0) {
            word.append("z")
            z--
        } else if (z == 0) {
            word.append("a")
            a--
        } else {
            if (dp[a - 1][z] >= v) {
                word.append("a")
                a--
            } else {
                word.append("z")
                v -= dp[a - 1][z]
                z--
            }
        }
    }
    return word.toString()
}

private fun getDp(): Array<IntArray> {
    val dp = Array(101) { IntArray(101) }
    (1..100).forEach { i -> dp[i][0] = 1 }
    (1..100).forEach { j -> dp[0][j] = 1 }
    (1..100).forEach { i ->
        (1..100).forEach { j ->
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            if (dp[i][j] > 1_000_000_000) {
                dp[i][j] = 1_000_000_001
            }
        }
    }
    return dp
}
