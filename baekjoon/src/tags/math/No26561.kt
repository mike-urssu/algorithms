package tags.math

/**
 * https://www.acmicpc.net/problem/26561
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (p, t) = readln().split(" ").map { it.toInt() }
        println(p - t / 7 + t / 4)
    }
}
