package tags.math

/**
 * https://www.acmicpc.net/problem/10275
 */
import kotlin.math.pow

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, a, b) = readln().split(" ").map { it.toLong() }
        println(divide(2.0.pow(n.toInt()).toLong(), maxOf(a, b)))
    }
}

private fun divide(n: Long, m: Long): Int {
    var days = 0
    var remainder = m
    var double = 2L
    while (remainder != 0L) {
        if (remainder >= n / double) {
            remainder -= n / double
        }
        double *= 2
        days++
    }
    return days
}
