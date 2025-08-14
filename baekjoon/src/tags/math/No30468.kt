package tags.math

/**
 * https://www.acmicpc.net/problem/30468
 */
fun main() {
    val (str, dex, int, luk, n) = readln().split(" ").map { it.toInt() }
    println(maxOf(0, n * 4 - str - dex - int - luk))
}
