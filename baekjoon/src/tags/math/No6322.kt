package tags.math

/**
 * https://www.acmicpc.net/problem/6322
 */
import kotlin.math.sqrt

fun main() {
    var index = 1
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0 && c == 0) {
            break
        }

        println("Triangle #${index++}")
        if (a == -1) {
            if (b >= c) {
                println("Impossible.")
            } else {
                val l = String.format("%.3f", sqrt((c * c - b * b).toDouble()))
                println("a = $l")
            }
        } else if (b == -1) {
            if (a >= c) {
                println("Impossible.")
            } else {
                val l = String.format("%.3f", sqrt((c * c - a * a).toDouble()))
                println("b = $l")
            }
        } else {
            val l = String.format("%.3f", sqrt((a * a + b * b).toDouble()))
            println("c = $l")
        }
        println()
    }
}
