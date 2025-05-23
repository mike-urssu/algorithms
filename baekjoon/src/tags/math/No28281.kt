package tags.math

/**
 * https://www.acmicpc.net/problem/28281
 */
fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    val prices = readln().split(" ").map { it.toInt() }.toIntArray()
    val min = (0 until n - 1).minOf { prices[it] + prices[it + 1] }
    println(min * x)
}
