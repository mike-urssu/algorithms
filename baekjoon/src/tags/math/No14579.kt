package tags.math

/**
 * https://www.acmicpc.net/problem/14579
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    var prev = (1..a).sum()
    var v = prev
    (a + 1..b).forEach { i ->
        prev += i
        v = (v * prev) % 14579
    }
    println(v)
}
