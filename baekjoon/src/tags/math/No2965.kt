package tags.math

/**
 * https://www.acmicpc.net/problem/2965
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(maxOf(b - a - 1, c - b - 1))
}
