package tags.geometry

/**
 * https://www.acmicpc.net/problem/31534
 */
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.PI

fun main() {
    val input = readln().split(" ").map { it.toDouble() }
    val a = input[0].coerceAtMost(input[1])
    val b = input[0].coerceAtLeast(input[1])
    val h = input[2]
    val area = when (a) {
        0.0 -> {
            val l = sqrt(h.pow(2) + b.pow(2))
            l.pow(2) * PI
        }

        b -> -1

        else -> {
            val l = sqrt(h.pow(2) + (b - a).pow(2))
            val m = b * l / (b - a)
            (m.pow(2) - (m - l).pow(2)) * PI
        }
    }
    println(area)
}
