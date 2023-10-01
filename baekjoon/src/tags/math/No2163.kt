package tags.math

/**
 * https://www.acmicpc.net/problem/2163
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }.sorted()
    val count = n - 1 + (m - 1) * n
    println(count)
}
