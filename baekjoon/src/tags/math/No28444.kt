package tags.math

/**
 * https://www.acmicpc.net/problem/28444
 */
fun main() {
    val (h, i, a, r, c) = readln().split(" ").map { it.toInt() }
    println(h * i - a * r * c)
}
