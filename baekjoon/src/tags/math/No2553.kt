package tags.math

/**
 * https://www.acmicpc.net/problem/2553
 */
fun main() {
    val n = readln().toInt()
    var remainder = 1L
    (1..n).forEach { i ->
        remainder *= i
        while (remainder % 10 == 0L) {
            remainder /= 10
        }
        remainder %= 1_000_000
    }
    println(remainder % 10)
}
