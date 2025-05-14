package tags.math

/**
 * https://www.acmicpc.net/problem/8710
 */
fun main() {
    val (k, w, m) = readln().split(" ").map { it.toInt() }
    println((w - k + m - 1) / m)
}
