package tags.math

/**
 * https://www.acmicpc.net/problem/30214
 */
fun main() {
    val (s1, s2) = readln().split(" ").map { it.toInt() }
    if (s1.shl(1) >= s2) {
        println("E")
    } else {
        println("H")
    }
}
