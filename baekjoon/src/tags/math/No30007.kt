package tags.math

/**
 * https://www.acmicpc.net/problem/30007
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (a, b, x) = readln().split(" ").map { it.toInt() }
        println(a * (x - 1) + b)
    }
}
