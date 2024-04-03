package tags.math

/**
 * https://www.acmicpc.net/problem/25238
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    if (a * (100 - b) / 100 >= 100) {
        println(0)
    } else {
        println(1)
    }
}
