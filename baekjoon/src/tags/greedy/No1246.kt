package tags.greedy

/**
 * https://www.acmicpc.net/problem/1246
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val prices = Array(m) { readln().toInt() }.sortedDescending()

    var price = Int.MIN_VALUE
    var profit = Int.MIN_VALUE
    for (i in 0 until n.coerceAtMost(m)) {
        val p = prices[i] * (i + 1)
        if (profit <= p) {
            price = prices[i]
            profit = p
        }
    }
    println("$price $profit")
}
