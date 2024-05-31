package tags.math

/**
 * https://www.acmicpc.net/problem/16673
 */
fun main() {
    val (c, k, p) = readln().split(" ").map { it.toInt() }
    val sum = (1..c).sumOf { n -> k * n + p * n * n }
    println(sum)
}
