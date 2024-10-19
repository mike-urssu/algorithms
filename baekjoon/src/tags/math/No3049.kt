package tags.math

/**
 * https://www.acmicpc.net/problem/3049
 */
fun main() {
    val n = readln().toInt()
    println(n * (n - 1) * (n - 2) * (n - 3) / 24)
}
