package tags.math

/**
 * https://www.acmicpc.net/problem/16199
 */
fun main() {
    val (y1, m1, d1) = readln().split(" ").map { it.toInt() }
    val (y2, m2, d2) = readln().split(" ").map { it.toInt() }

    if (m1 < m2 || m1 == m2 && d1 <= d2) {
        println(y2 - y1)
    } else {
        println(y2 - y1 - 1)
    }

    println(y2 - y1 + 1)
    println(y2 - y1)
}
