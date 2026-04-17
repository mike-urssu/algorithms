package tags.math

/**
 * https://www.acmicpc.net/problem/34921
 */
fun main() {
    val (a, t) = readln().split(" ").map { it.toInt() }
    val p = maxOf(10 + 2 * (25 - a + t), 0)
    println(p)
}
