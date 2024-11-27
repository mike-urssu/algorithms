package tags.math

/**
 * https://www.acmicpc.net/problem/8723
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
    val type = if (a == b && b == c) {
        2
    } else if (a * a + b * b == c * c) {
        1
    } else {
        0
    }
    println(type)
}
