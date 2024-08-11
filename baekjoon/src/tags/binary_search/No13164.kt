package tags.binary_search

/**
 * https://www.acmicpc.net/problem/13164
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val heights = readln().split(" ").map { it.toInt() }
    val gap = IntArray(n - 1) { heights[it + 1] - heights[it] }.sortedArrayDescending()
    val cost = gap.drop(k - 1).sum()
    println(cost)
}
