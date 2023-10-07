package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2022
 */
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val (x, y, c) = readln().split(" ").map { it.toDouble() }
    println(String.format("%.3f", getDistance(x, y, c)))
}

private fun getDistance(x: Double, y: Double, c: Double): Double {
    var low = 0.0
    var high = 3000000000.0
    while (high - low >= 0.001) {
        val mid = (low + high) / 2
        if (isValid(x, y, c, mid)) {
            low = mid
        } else {
            high = mid
        }
    }
    return high
}

private fun isValid(x: Double, y: Double, c: Double, l: Double): Boolean {
    val h1 = getHeight(x, l)
    val h2 = getHeight(y, l)
    return (h1 * h2) / (h1 + h2) >= c
}

private fun getHeight(x: Double, l: Double) =
    sqrt(x.pow(2) - l.pow(2))
