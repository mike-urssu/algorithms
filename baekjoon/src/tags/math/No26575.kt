package tags.math

/**
 * https://www.acmicpc.net/problem/26575
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (d, f, p) = readln().split(" ").map { it.toDouble() }
        println("$${String.format("%.2f", d * f * p)}")
    }
}
