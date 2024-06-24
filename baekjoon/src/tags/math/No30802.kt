package tags.math

/**
 * https://www.acmicpc.net/problem/30802
 */
fun main() {
    val n = readln().toInt()
    val shirts = readln().split(" ").map { it.toInt() }.toIntArray()
    val (t, p) = readln().split(" ").map { it.toInt() }

    println(shirts.sumOf { (it + t - 1) / t })
    println("${n / p} ${n - n / p * p}")
}
