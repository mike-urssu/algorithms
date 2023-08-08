package tags.dp

/**
 * https://www.acmicpc.net/problem/11049
 */
fun main() {
    val n = readln().toInt()
    val matrices = getMatrices(n)
    val dp = getDp(n, matrices)
    println(dp[1][n])
}

private fun getMatrices(n: Int): Array<Array<Pair<Int, Int>>> {
    val matrices = Array(n + 1) { Array(n + 1) { Pair(0, 0) } }.apply {
        (1..n).forEach { i ->
            val (r, c) = readln().split(" ").map { it.toInt() }
            this[i][i] = Pair(r, c)
        }
    }
    for (i in n - 1 downTo 1) {
        for (j in i + 1..n) {
            matrices[i][j] = Pair(matrices[i][i].first, matrices[j][j].second)
        }
    }
    return matrices
}

private fun getDp(n: Int, matrices: Array<Array<Pair<Int, Int>>>): Array<IntArray> {
    val dp = Array(n + 1) { IntArray(n + 1) }
    for (i in n - 1 downTo 1) {
        for (j in i + 1..n) {
            dp[i][j] = Int.MAX_VALUE
            if (i + 1 == j) {
                dp[i][j] = mul(matrices, i, i, i, j)
            } else {
                for (k in i until j) {
                    dp[i][j] = dp[i][j].coerceAtMost(mul(matrices, i, k, k + 1, j) + dp[i][k] + dp[k + 1][j])
                }
            }
        }
    }
    return dp
}

private fun mul(matrices: Array<Array<Pair<Int, Int>>>, r1: Int, c1: Int, r2: Int, c2: Int) =
    matrices[r1][c1].first * matrices[r1][c1].second * matrices[r2][c2].second
