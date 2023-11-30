package tags.dp

/**
 * https://www.acmicpc.net/problem/15486
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = reader.readLine().toInt()
    val times = IntArray(n + 2)
    val prices = IntArray(n + 2)
    for (i in 1..n) {
        val (t, p) = reader.readLine().split(" ").map { it.toInt() }
        times[i] = t
        prices[i] = p
    }
    println(getMaxProfit(n, times, prices))
}

private fun getMaxProfit(n: Int, times: IntArray, prices: IntArray): Int {
    val profits = IntArray(n + 2)
    (n downTo 1).forEach { i ->
        profits[i] = if (i + times[i] - 1 > n) {
            profits[i + 1]
        } else {
            maxOf(prices[i] + profits[i + times[i]], profits[i + 1])
        }
    }
    return profits[1]
}
