package tags.math

/**
 * https://www.acmicpc.net/problem/14489
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val c = readln().toInt()
    if (a + b >= c * 2) {
        println(a + b - c * 2)
    } else {
        println(a + b)
    }
}
