package tags.sorting

/**
 * https://www.acmicpc.net/problem/20044
 */
fun main() {
    val n = readln().toInt()
    val w = readln().split(" ").map { it.toInt() }.sorted()
    val min = (0 until n).minOf { i -> w[i] + w[2 * n - i - 1] }
    println(min)
}
