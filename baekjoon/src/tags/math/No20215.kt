package tags.math

/**
 * https://www.acmicpc.net/problem/20215
 */
import kotlin.math.sqrt

fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    println(w + h - sqrt(w * w + h * h.toDouble()))
}
