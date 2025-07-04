package tags.math

/**
 * https://www.acmicpc.net/problem/10599
 */
fun main() {
    while (true) {
        val (a, b, c, d) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0 && c == 0 && d == 0) {
            break
        }
        println("${c - b} ${d - a}")
    }
}
