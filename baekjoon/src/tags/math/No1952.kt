package tags.math

/**
 * https://www.acmicpc.net/problem/1952
 */
fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val count = if (m <= n) {
        (m - 1) shl 1
    } else {
        (n shl 1) - 1
    }
    println(count)
}
