package tags.math

/**
 * https://www.acmicpc.net/problem/2914
 */
fun main() {
    val (a, i) = readln().split(" ").map { it.toInt() }
    println(a * (i - 1) + 1)
}
