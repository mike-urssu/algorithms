package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1487
 */
fun main() {
    val numberOfInput = readln().toInt()
    val prices = IntArray(numberOfInput)
    val deliveryCosts = IntArray(numberOfInput)
    for (i in 0 until numberOfInput) {
        val (price, deliveryCost) = readln().split(" ").map { it.toInt() }
        prices[i] = price
        deliveryCosts[i] = deliveryCost
    }

    var maxPrice = 0
    var maxBenefit = 0
    for (price in prices.distinct().sorted()) {
        var benefit = 0
        for (i in prices.indices) {
            if (price <= prices[i] && price > deliveryCosts[i]) {
                benefit += price - deliveryCosts[i]
            }
        }

        if (maxBenefit < benefit) {
            maxBenefit = benefit
            maxPrice = price
        }
    }

    println(maxPrice)
}
