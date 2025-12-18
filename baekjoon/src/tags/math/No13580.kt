package tags.math

/**
 * https://www.acmicpc.net/problem/13580
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
    if (a == b || b == c || a + b == c) {
        println("S")
    } else {
        println("N")
    }
}
