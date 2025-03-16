package tags.dp

/**
 * https://www.acmicpc.net/problem/2229
 */
fun main() {
    val n = readln().toInt()
    val scores = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }

    val dp = IntArray(n + 1)
    (2..n).forEach { i ->
        var max = scores[i]
        var min = scores[i]

        for (j in i - 1 downTo 1) {
            max = maxOf(max, scores[j])
            min = minOf(min, scores[j])

            val sum = dp[j - 1] + max - min
            dp[i] = maxOf(dp[i], sum)
        }
    }

    println(dp.last())
}
