package tags.math

/**
 * https://www.acmicpc.net/problem/32215
 */
fun main() {
    val (_, m, k) = readln().split(" ").map { it.toInt() }
    println((k + 1) * m)
}
