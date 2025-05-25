package tags.math

/**
 * https://www.acmicpc.net/problem/15474
 */
fun main() {
    val (n, a, b, c, d) = readln().split(" ").map { it.toInt() }
    val min = minOf((n + a - 1) / a * b, (n + c - 1) / c * d)
    println(min)
}
