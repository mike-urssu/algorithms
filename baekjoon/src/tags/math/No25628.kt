package tags.math

/**
 * https://www.acmicpc.net/problem/25628
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(minOf(a / 2, b))
}
