package tags.dp

/**
 * https://www.acmicpc.net/problem/1495
 */
fun main() {
    val (n, s, m) = readln().split(" ").map { it.toInt() }
    val v = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getMaxVolume(n, s, m, v))
}

private fun getMaxVolume(n: Int, s: Int, m: Int, v: IntArray): Int {
    val dp = Array(n + 1) { BooleanArray(m + 1) }
    dp[0][s] = true
    (1..n).forEach { i ->
        (0..m).filter { j -> dp[i - 1][j] }
            .forEach { j ->
                if (j + v[i - 1] in 0..m) {
                    dp[i][j + v[i - 1]] = true
                }
                if (j - v[i - 1] in 0..m) {
                    dp[i][j - v[i - 1]] = true
                }
            }
    }

    return if (dp.last().any { it }) {
        dp.last().indexOfLast { it }
    } else {
        -1
    }
}
