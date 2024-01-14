package tags.geometry

/**
 * https://www.acmicpc.net/problem/1069
 */
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val (x, y, d, t) = readln().split(" ").map { it.toDouble() }
    println(getTime(x, y, d, t))
}

private fun getTime(x: Double, y: Double, d: Double, t: Double): Double {
    val distance = sqrt(x.pow(2) + y.pow(2))
    return if (distance < d) {
        minOf(distance, t + (d - distance), t * 2)
    } else {
        val jump = (distance / d).toInt()
        minOf(distance, t * jump + (distance - d * jump), t * (jump + 1))
    }
}
