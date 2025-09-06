package tags.math

/**
 * https://www.acmicpc.net/problem/8674
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    if (a % 2 == 0L || b % 2 == 0L) {
        println(0)
    } else {
        println(minOf(a, b))
    }
}
