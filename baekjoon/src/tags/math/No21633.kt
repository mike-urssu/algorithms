package tags.math

/**
 * https://www.acmicpc.net/problem/21633
 */
fun main() {
    val k = readln().toInt()
    println(String.format("%.2f", minOf(maxOf(100.0, k * 0.01 + 25), 2000.0)))
}
