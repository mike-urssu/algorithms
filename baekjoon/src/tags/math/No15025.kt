package tags.math

/**
 * https://www.acmicpc.net/problem/15025
 */
fun main() {
    val (l, r) = readln().split(" ").map { it.toInt() }
    if (l == 0 && r == 0) {
        println("Not a moose")
    } else if (l == r) {
        println("Even ${l + r}")
    } else {
        println("Odd ${maxOf(l, r) * 2}")
    }
}
