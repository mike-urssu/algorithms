package tags.math

/**
 * https://www.acmicpc.net/problem/28224
 */
fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { readln().toInt() }
    println(numbers.sum())
}
