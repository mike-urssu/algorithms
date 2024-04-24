package tags.math

/**
 * https://www.acmicpc.net/problem/13866
 */
import kotlin.math.abs

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    println(abs((b + c) - (a + d)))
}
