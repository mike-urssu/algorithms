package tags.math

/**
 * https://www.acmicpc.net/problem/2997
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
    val diff1 = b - a
    val diff2 = c - b
    val d = when (diff1 / diff2) {
        0 -> b + diff1
        1 -> c + diff1
        else -> a + diff2
    }
    println(d)
}
