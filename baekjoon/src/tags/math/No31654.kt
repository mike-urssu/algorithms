package tags.math

/**
 * https://www.acmicpc.net/problem/31654
 */
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    if (a + b == c) {
        println("correct!")
    } else {
        println("wrong!")
    }
}
