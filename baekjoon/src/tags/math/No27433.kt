package tags.math

/**
 * https://www.acmicpc.net/problem/27433
 */
fun main() {
    val n = readln().toInt()
    var factorial = 1L
    (1..n).forEach { i -> factorial *= i }
    println(factorial)
}
