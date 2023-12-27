package tags.math

/**
 * https://www.acmicpc.net/problem/13458
 */
fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    val (b, c) = readln().split(" ").map { it.toLong() }
    val sum = n + a.sumOf { maxOf(0, (it - b + c - 1) / c) }
    println(sum)
}
