package tags.math

/**
 * https://www.acmicpc.net/problem/26082
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(b / a * c * 3)
}
