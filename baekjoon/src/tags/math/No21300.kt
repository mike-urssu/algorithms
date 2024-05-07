package tags.math

/**
 * https://www.acmicpc.net/problem/21300
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    val refund = numbers.sum() * 5
    println(refund)
}
