package tags.math

/**
 * https://www.acmicpc.net/problem/16204
 */
fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    println(minOf(m, k) + minOf(n - m, n - k))
}
