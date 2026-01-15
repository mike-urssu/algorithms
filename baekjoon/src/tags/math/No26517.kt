package tags.math

/**
 * https://www.acmicpc.net/problem/26517
 */
fun main() {
    val k = readln().toInt()
    val (a, b, c, d) = readln().split(" ").map { it.toLong() }
    val f1 = a * k + b
    val f2 = c * k + d
    if (f1 == f2) {
        println("Yes $f1")
    } else {
        println("No")
    }
}
