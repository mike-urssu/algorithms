package tags.math

/**
 * https://www.acmicpc.net/problem/25784
 */
fun main() {
    val (n1, n2, n3) = readln().split(" ").map { it.toInt() }.sorted()
    val v = if (n1 + n2 == n3) {
        1
    } else if (n1 * n2 == n3) {
        2
    } else {
        3
    }
    println(v)
}
