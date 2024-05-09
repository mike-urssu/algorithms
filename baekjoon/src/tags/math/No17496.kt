package tags.math

/**
 * https://www.acmicpc.net/problem/17496
 */
fun main() {
    val (n, t, c, p) = readln().split(" ").map { it.toInt() }
    val profit = ((n + t - 1) / t - 1) * c * p
    println(profit)
}
