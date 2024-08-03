package tags.geometry

/**
 * https://www.acmicpc.net/problem/2166
 */
import kotlin.math.abs
import kotlin.math.roundToLong

fun main() {
    val n = readln().toInt()
    val points = Array(n) {
        val (x, y) = readln().split(" ").map { it.toDouble() }
        Pair(x, y)
    }

    val area = calculateArea(points)
    println(String.format("%.1f", (area * 10).roundToLong() / 10.0))
}

private fun calculateArea(points: Array<Pair<Double, Double>>): Double {
    var area = 0.0
    val n = points.size
    for (i in 0 until n) {
        val j = (i + 1) % n
        area += (points[i].first + points[j].first) * (points[i].second - points[j].second)
    }

    area = abs(area) / 2.0
    return area
}
