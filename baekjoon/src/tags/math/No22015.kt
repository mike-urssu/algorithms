package tags.math

/**
 * https://www.acmicpc.net/problem/22015
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val max = maxOf(a, b, c)
    println(max * 3 - a - b - c)
}
