package tags.math

/**
 * https://www.acmicpc.net/problem/25625
 */
fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    if (x > y) {
        println(x + y)
    } else {
        println(y - x)
    }
}
