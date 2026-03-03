package tags.math

/**
 * https://www.acmicpc.net/problem/11970
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }
    val l = if (d < a) {
        d - c + b - a
    } else if (d in a..b) {
        b - minOf(a, c)
    } else {
        if (c < a) {
            d - c
        } else if (c in a..b) {
            d - a
        } else {
            d - c + b - a
        }
    }
    println(l)
}
