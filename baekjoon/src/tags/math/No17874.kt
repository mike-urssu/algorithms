package tags.math

/**
 * https://www.acmicpc.net/problem/17874
 */
fun main() {
    val (n, h, v) = readln().split(" ").map { it.toInt() }
    val a = maxOf(n - h, h)
    val b = maxOf(n - v, v)
    println(a * b * 4)
}
