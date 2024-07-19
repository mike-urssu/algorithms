package tags.math

/**
 * https://www.acmicpc.net/problem/2896
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val (i, j, k) = readln().split(" ").map { it.toDouble() }
    val ratio = minOf(a / i, b / j, c / k)
    println("${a - i * ratio} ${b - j * ratio} ${c - k * ratio}")
}
