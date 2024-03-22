package tags.math

/**
 * https://www.acmicpc.net/problem/30017
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val size = 3 + minOf(a - 2, b - 1) * 2
    println(size)
}
