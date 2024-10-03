package tags.dp

/**
 * https://www.acmicpc.net/problem/12869
 */
fun main() {
    val hp = IntArray(3).apply {
        readln()
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this)
    }
    val damages = arrayOf(
        intArrayOf(9, 3, 1),
        intArrayOf(9, 1, 3),
        intArrayOf(3, 9, 1),
        intArrayOf(3, 1, 9),
        intArrayOf(1, 9, 3),
        intArrayOf(1, 3, 9)
    )

    val dp = Array(61) { Array(61) { IntArray(61) } }
    dp[hp[0]][hp[1]][hp[2]] = 1
    (hp[0] downTo 0).forEach { i ->
        (hp[1] downTo 0).forEach { j ->
            (hp[2] downTo 0).forEach { k ->
                if (dp[i][j][k] != 0) {
                    for ((d1, d2, d3) in damages) {
                        val nextI = (i - d1).coerceAtLeast(0)
                        val nextJ = (j - d2).coerceAtLeast(0)
                        val nextK = (k - d3).coerceAtLeast(0)

                        dp[nextI][nextJ][nextK] = if (dp[nextI][nextJ][nextK] == 0) {
                            dp[i][j][k] + 1
                        } else {
                            dp[nextI][nextJ][nextK].coerceAtMost(dp[i][j][k] + 1)
                        }
                    }
                }
            }
        }
    }

    println(dp[0][0][0] - 1)
}
