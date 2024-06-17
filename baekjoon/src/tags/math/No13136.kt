package tags.math

/**
 * https://www.acmicpc.net/problem/13136
 */
fun main() {
    val (r, c, n) = readln().split(" ").map { it.toLong() }
    println(((r + n - 1) / n) * ((c + n - 1) / n))
}
