package tags.math

/**
 * https://www.acmicpc.net/problem/24075
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(maxOf(a + b, a - b))
    println(minOf(a + b, a - b))
}
