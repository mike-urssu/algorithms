package tags.math

/**
 * https://www.acmicpc.net/problem/16504
 */
fun main() {
    val n = readln().toInt()
    val paper = Array(n) { readln().split(" ").map { it.toLong() }.toLongArray() }
    val sum = paper.sumOf { it.sum() }
    println(sum)
}
