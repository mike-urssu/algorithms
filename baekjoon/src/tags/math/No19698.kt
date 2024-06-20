package tags.math

/**
 * https://www.acmicpc.net/problem/19698
 */
fun main() {
    val (n, w, h, l) = readln().split(" ").map { it.toInt() }
    println(n.coerceAtMost((w / l) * (h / l)))
}
