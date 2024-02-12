package tags.math

/**
 * https://www.acmicpc.net/problem/1297
 */
import kotlin.math.sqrt

fun main() {
    val (d, h, w) = readln().split(" ").map { it.toDouble() }
    val ratio = d / sqrt(h * h + w * w)
    println("${(h * ratio).toInt()} ${(w * ratio).toInt()}")
}
