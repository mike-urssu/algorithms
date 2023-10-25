package tags.dp

/**
 * https://www.acmicpc.net/problem/16194
 */
fun main() {
    val n = readln().toInt()
    val prices = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    println(getLeastCost(n, prices))
}

private fun getLeastCost(n: Int, prices: IntArray): Int {
    val costs = IntArray(n + 1)
    (1..n).forEach { i ->
        val min = (0 until i).minOf { j -> prices[i - j] + costs[j] }
        costs[i] = min
    }
    return costs[n]
}
