package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/14501
 */
fun main() {
    val n = readln().toInt()
    val periods = mutableListOf<Int>()
    val prices = mutableListOf<Int>()
    repeat(n) {
        val (t, p) = readln().split(" ").map { it.toInt() }
        periods.add(t)
        prices.add(p)
    }
    periods.add(0)
    prices.add(0)

    var max = 0
    val dp = IntArray(n + 1)
    for (i in n - 1 downTo 0) {
        if (i + periods[i] > n) {
            dp[i] = max
            continue
        }
        max = max.coerceAtLeast(prices[i] + dp[i + periods[i]])
        dp[i] = max
    }

    println(dp.first())
}
