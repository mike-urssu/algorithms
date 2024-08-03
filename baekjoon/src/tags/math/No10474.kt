package tags.math

/**
 * https://www.acmicpc.net/problem/10474
 */
fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0) {
            break
        }
        println("${a / b} ${a % b} / $b")
    }
}
