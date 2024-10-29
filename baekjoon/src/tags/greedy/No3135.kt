package tags.greedy

/**
 * https://www.acmicpc.net/problem/3135
 */
import kotlin.math.abs

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()
    val frequencies = IntArray(n) { readln().toInt() }
    var min = frequencies.minOf { f -> abs(b - f) } + 1
    min = min.coerceAtMost(abs(a - b))
    println(min)
}
