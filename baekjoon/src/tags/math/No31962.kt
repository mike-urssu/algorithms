package tags.math

/**
 * https://www.acmicpc.net/problem/31962
 */
fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    var max = -1
    repeat(n) {
        val (s, t) = readln().split(" ").map { it.toInt() }
        if (s + t <= x) {
            max = maxOf(max, s)
        }
    }
    println(max)
}
