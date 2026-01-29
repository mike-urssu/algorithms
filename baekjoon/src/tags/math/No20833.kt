package tags.math

/**
 * https://www.acmicpc.net/problem/20833
 */
fun main() {
    val n = readln().toInt()
    val sum = (1..n).sumOf { it * it * it }
    println(sum)
}
