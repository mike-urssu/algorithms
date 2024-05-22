package tags.math

/**
 * https://www.acmicpc.net/problem/25191
 */
fun main() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(minOf(n, a / 2 + b))
}
