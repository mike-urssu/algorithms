package tags.math

/**
 * https://www.acmicpc.net/problem/10156
 */
fun main() {
    val (k, n, m) = readln().split(" ").map { it.toInt() }
    println(maxOf(k * n - m, 0))
}
