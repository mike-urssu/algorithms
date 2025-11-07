package tags.math

/**
 * https://www.acmicpc.net/problem/31668
 */
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val k = readln().toInt()
    println((m + n - 1) / n * k)
}
