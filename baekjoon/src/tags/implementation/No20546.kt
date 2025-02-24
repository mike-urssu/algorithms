package tags.implementation

/**
 * https://www.acmicpc.net/problem/20546
 */
fun main() {
    val money = readln().toInt()
    val prices = readln().split(" ").map { it.toInt() }.toIntArray()

    val m1 = getStock1(money, prices)
    val m2 = getStock2(money, prices)
    if (m1 > m2) {
        println("BNP")
    } else if (m1 == m2) {
        println("SAMESAME")
    } else {
        println("TIMING")
    }
}

private fun getStock1(money: Int, prices: IntArray): Int {
    var remainder = money
    var stock = 0
    prices.forEach { price ->
        stock += remainder / price
        remainder %= price
    }
    return remainder + stock * prices.last()
}

private fun getStock2(money: Int, prices: IntArray): Int {
    var remainder = money
    var stock = 0
    (3 until prices.size).forEach { i ->
        if (isDecreasing(prices, i)) {
            val s = remainder / prices[i]
            remainder -= prices[i] * s
            stock += s
        } else if (isIncreasing(prices, i)) {
            remainder += stock * prices[i]
            stock = 0
        }
    }
    return remainder + stock * prices.last()
}

private fun isIncreasing(prices: IntArray, index: Int) =
    prices[index - 3] < prices[index - 2] && prices[index - 2] < prices[index - 1] && prices[index - 1] < prices[index]

private fun isDecreasing(prices: IntArray, index: Int) =
    prices[index - 3] > prices[index - 2] && prices[index - 2] > prices[index - 1] && prices[index - 1] > prices[index]
