package tags.math

/**
 * https://www.acmicpc.net/problem/17356
 */
import kotlin.math.pow

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val m = (b - a) / 400.0
    println(1 / (1 + 10.0.pow(m)))
}
