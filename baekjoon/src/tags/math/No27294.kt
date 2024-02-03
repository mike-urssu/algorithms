package tags.math

/**
 * https://www.acmicpc.net/problem/27294
 */
fun main() {
    val (t, s) = readln().split(" ").map { it.toInt() }
    if (t in 12..16 && s == 0) {
        println(320)
    } else {
        println(280)
    }
}
