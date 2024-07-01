package tags.dp

/**
 * https://www.acmicpc.net/problem/2342
 */
fun main() {
    val numbers = mutableListOf<Int>().apply {
        this.add(0)
        this.addAll(readln().split(" ").map { it.toInt() }.dropLast(1))
    }

    val dp = Array(numbers.size) { Array(5) { IntArray(5) { 1_000_000 } } }
    dp[0][0][0] = 0
    for (i in 1 until numbers.size) {
        val n = numbers[i]
        (0 until 5).forEach { l ->
            (0 until 5).forEach { r ->
                dp[i][l][n] = dp[i][l][n].coerceAtMost(dp[i - 1][l][r] + getDistance(r, n))
                dp[i][n][r] = dp[i][n][r].coerceAtMost(dp[i - 1][l][r] + getDistance(l, n))
            }
        }
    }

    println(dp.last().minOf { it.min() })
}

private fun getDistance(n1: Int, n2: Int): Int {
    return if (n1 == 0) {
        2
    } else if (n1 == 1) {
        when (n2) {
            1 -> 1
            3 -> 4
            else -> 3
        }
    } else if (n1 == 2) {
        when (n2) {
            2 -> 1
            4 -> 4
            else -> 3
        }
    } else if (n1 == 3) {
        when (n2) {
            3 -> 1
            1 -> 4
            else -> 3
        }
    } else {
        when (n2) {
            4 -> 1
            2 -> 4
            else -> 3
        }
    }
}
