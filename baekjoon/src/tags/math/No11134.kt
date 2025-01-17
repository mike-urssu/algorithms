package tags.math

/**
 * https://www.acmicpc.net/problem/11134
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, c) = readln().split(" ").map { it.toInt() }
        println((n + c - 1) / c)
    }
}
