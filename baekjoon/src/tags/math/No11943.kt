package tags.math

/**
 * https://www.acmicpc.net/problem/11943
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }
    println(minOf(a + d, b + c))
}
