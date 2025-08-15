package tags.math

/**
 * https://www.acmicpc.net/problem/32314
 */
fun main() {
    val a = readln().toInt()
    val (w, v) = readln().split(" ").map { it.toInt() }
    if (a <= w / v) {
        println(1)
    } else {
        println(0)
    }
}
