package tags.math

/**
 * https://www.acmicpc.net/problem/16693
 */
fun main() {
    val (a1, p1) = readln().split(" ").map { it.toDouble() }
    val (r1, p2) = readln().split(" ").map { it.toDouble() }
    val pizza = if (a1 / p1 > r1 * r1 * Math.PI / p2) {
        "Slice of pizza"
    } else {
        "Whole pizza"
    }
    println(pizza)
}
