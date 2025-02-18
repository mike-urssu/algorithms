package tags.greedy

/**
 * https://www.acmicpc.net/problem/11034
 */
fun main() {
    while (true) {
        val (a, b, c) = (readlnOrNull() ?: break).split(" ").map { it.toInt() }
        println((b - a - 1).coerceAtLeast(c - b - 1))
    }
}
