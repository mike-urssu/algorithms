package tags.math

/**
 * https://www.acmicpc.net/problem/34217
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }
    val s1 = a + c
    val s2 = b + d
    val s = if (s1 < s2) {
        "Hanyang Univ."
    } else if (s1 > s2) {
        "Yongdap"
    } else {
        "Either"
    }
    println(s)
}
