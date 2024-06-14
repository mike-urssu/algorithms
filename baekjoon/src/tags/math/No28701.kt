package tags.math

/**
 * https://www.acmicpc.net/problem/28701
 */
fun main() {
    val n = readln().toInt()
    println((1..n).sum())
    println((1..n).sum() * (1..n).sum())
    println((1..n).sumOf { it * it * it })
}
