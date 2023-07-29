package tags.greedy

/**
 * https://www.acmicpc.net/problem/11501
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val prices = readln().split(" ").map { it.toInt() }.toIntArray()
        println(getMaxBenefit(prices))
    }
}

private fun getMaxBenefit(prices: IntArray): Long {
    var benefit = 0L
    var max = prices.last()
    for (i in prices.lastIndex - 1 downTo 0) {
        if (prices[i] <= max) {
            benefit += max - prices[i]
        } else {
            max = prices[i]
        }
    }
    return benefit
}
