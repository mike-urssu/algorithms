package tags.math

/**
 * https://www.acmicpc.net/problem/14065
 */
fun main() {
    val x = readln().toDouble()
    println(String.format("%.6f", 100 / (1.609344 / 3.785411784 * x)))
}
