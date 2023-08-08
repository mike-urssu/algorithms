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
            dp[i][j] = calculate(matrices, dp, i, j)
        }
    }
    return dp
}

private fun calculate(matrices: Array<Array<Pair<Int, Int>>>, dp: Array<IntArray>, i: Int, j: Int): Int {
    var min = Int.MAX_VALUE
    if (i + 1 == j) {
        min = min.coerceAtMost(matrices[i][i].first * matrices[i][i].second * matrices[j][j].second)
    } else {
        for (k in i until j) {
            min = min.coerceAtMost(
                matrices[i][k].first * matrices[i][k].second * matrices[k + 1][j].second
                        + dp[i][k] + dp[k + 1][j]
            )
        }
    }
    return min
}
