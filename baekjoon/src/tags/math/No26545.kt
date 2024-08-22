package tags.math

/**
 * https://www.acmicpc.net/problem/26545
 */
fun main() {
    val n = readln().toInt()
    val sum = (0 until n).sumOf { readln().toInt() }
    println(sum)
}
