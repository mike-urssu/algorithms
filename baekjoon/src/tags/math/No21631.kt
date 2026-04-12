package tags.math

/**
 * https://www.acmicpc.net/problem/21631
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    val v = if (a < b) {
        a + 1
    } else {
        b
    }
    println(v)
}
