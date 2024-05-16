package tags.math

/**
 * https://www.acmicpc.net/problem/23825
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(minOf(n / 2, m / 2))
}
