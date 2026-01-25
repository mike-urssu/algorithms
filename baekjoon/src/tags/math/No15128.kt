package tags.math

/**
 * https://www.acmicpc.net/problem/15128
 */
fun main() {
    val (p1, q1, p2, q2) = readln().split(" ").map { it.toLong() }
    val v = if (p1 * p2 >= q1 * q2 * 2 && p1 * p2 % (q1 * q2 * 2) == 0L) {
        1
    } else {
        0
    }
    println(v)
}
