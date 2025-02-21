package tags.math

/**
 * https://www.acmicpc.net/problem/5691
 */
fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0) {
            break
        }
        val c = a * 2 - b
        println(c)
    }
}
