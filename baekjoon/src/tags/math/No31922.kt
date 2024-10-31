package tags.math

/**
 * https://www.acmicpc.net/problem/31922
 */
fun main() {
    val (a, p, c) = readln().split(" ").map { it.toInt() }
    println(p.coerceAtLeast(a + c))
}
