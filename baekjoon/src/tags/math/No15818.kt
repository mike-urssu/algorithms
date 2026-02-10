package tags.math

/**
 * https://www.acmicpc.net/problem/15818
 */
fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toLong() }.toLongArray()
    val mul = numbers.fold(1L) { acc, i -> ((acc % m) * (i % m)) % m }
    println(mul)
}
