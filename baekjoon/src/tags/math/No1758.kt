package tags.math

/**
 * https://www.acmicpc.net/problem/1758
 */
fun main() {
    val n = readln().toInt()
    val tips = LongArray(n) { readln().toLong() }.sortedDescending()
    val sum = (0 until n).sumOf { i -> 0L.coerceAtLeast((tips[i] - i)) }
    println(sum)
}
