package tags.math

/**
 * https://www.acmicpc.net/problem/5565
 */
fun main() {
    val totalCost = readln().toInt()
    val prices = IntArray(9) { readln().toInt() }
    println(totalCost - prices.sum())
}
