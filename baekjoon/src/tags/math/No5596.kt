package tags.math

/**
 * https://www.acmicpc.net/problem/5596
 */
fun main() {
    val sum1 = readln().split(" ").sumOf { it.toInt() }
    val sum2 = readln().split(" ").sumOf { it.toInt() }
    println(sum1.coerceAtLeast(sum2))
}
