package tags.math

/**
 * https://www.acmicpc.net/problem/2959
 */
fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }.sorted()
    println(minOf(a, b) * minOf(c, d))
}
