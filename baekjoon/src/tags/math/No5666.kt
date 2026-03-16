package tags.math

/**
 * https://www.acmicpc.net/problem/5666
 */
fun main() {
    while (true) {
        val s = readlnOrNull() ?: break
        val (h, p) = s.split(" ").map { it.toDouble() }
        println(String.format("%.2f", h / p))
    }
}
