package tags.math

/**
 * https://www.acmicpc.net/problem/10103
 */
fun main() {
    val n = readln().toInt()
    val scores = intArrayOf(100, 100)
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a > b) {
            scores[1] -= a
        } else if (a < b) {
            scores[0] -= b
        }
    }
    scores.forEach { println(it) }
}
