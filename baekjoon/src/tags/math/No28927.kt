package tags.math

/**
 * https://www.acmicpc.net/problem/28927
 */
fun main() {
    val (t1, e1, f1) = readln().split(" ").map { it.toInt() }
    val (t2, e2, f2) = readln().split(" ").map { it.toInt() }
    val s1 = t1 * 3 + e1 * 20 + f1 * 120
    val s2 = t2 * 3 + e2 * 20 + f2 * 120
    if (s1 > s2) {
        println("Max")
    } else if (s1 == s2) {
        println("Draw")
    } else {
        println("Mel")
    }
}
