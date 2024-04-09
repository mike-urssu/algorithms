package tags.math

/**
 * https://www.acmicpc.net/problem/1834
 */
fun main() {
    val n = readln().toLong()
    val sum = (1 until n).sumOf { i -> i * n + i }
    println(sum)
}
