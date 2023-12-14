package tags.geometry

/**
 * https://www.acmicpc.net/problem/7869
 */
import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

fun main() {
    val input = readln().split(" ").map { it.toDouble() }
    val x1 = input[0]
    val y1 = input[1]
    val r1 = input[2]
    val x2 = input[3]
    val y2 = input[4]
    val r2 = input[5]
    println(String.format("%.03f", getIntersectingArea(x1, y1, r1, x2, y2, r2)))
}

private fun getIntersectingArea(x1: Double, y1: Double, r1: Double, x2: Double, y2: Double, r2: Double): Double {
    val distance = getDistance(x1, y1, x2, y2)
    if (!isIntersecting(r1, r2, distance)) {
        return 0.0
    }
    if (isOverlapped(r1, r2, distance)) {
        return minOf(r1, r2).pow(2) * PI
    }
    return getArea(r1, distance, r2) + getArea(r2, distance, r1)
}

private fun getDistance(x1: Double, y1: Double, x2: Double, y2: Double) =
    sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

private fun isIntersecting(r1: Double, r2: Double, distance: Double) =
    distance <= r1 + r2

private fun isOverlapped(r1: Double, r2: Double, distance: Double) =
    maxOf(r1, r2) >= minOf(r1, r2) + distance

private fun getArea(a: Double, b: Double, c: Double): Double {
    val theta = acos((a.pow(2) + b.pow(2) - c.pow(2)) / (2 * a * b)) * 2
    return a.pow(2) * theta / 2 - a.pow(2) * sin(theta) / 2
}
