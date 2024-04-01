package tags.math

/**
 * https://www.acmicpc.net/problem/14924
 */
fun main() {
    val (s, t, d) = readln().split(" ").map { it.toInt() }
    println(d / (s * 2) * t)
}
