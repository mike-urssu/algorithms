package tags.math

/**
 * https://www.acmicpc.net/problem/5928
 */
fun main() {
    val (d, h, m) = readln().split(" ").map { it.toInt() }
    val minutes = ((d * 24 * 60 + h * 60 + m) - (11 * 24 * 60 + 11 * 60 + 11)).coerceAtLeast(-1)
    println(minutes)
}
