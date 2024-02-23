package tags.math

/**
 * https://www.acmicpc.net/problem/15726
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toDouble() }
    println(maxOf(a * b / c, a / b * c).toInt())
}
