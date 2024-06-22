package tags.math

/**
 * https://www.acmicpc.net/problem/23971
 */
import kotlin.math.ceil

fun main() {
    val (h, w, n, m) = readln().split(" ").map { it.toDouble() }
    println((ceil(h / (n + 1)) * ceil(w / (m + 1))).toInt())
}
