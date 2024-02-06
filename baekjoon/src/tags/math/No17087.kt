package tags.math

/**
 * https://www.acmicpc.net/problem/17087
 */
import kotlin.math.abs

fun main() {
    val (_, s) = readln().split(" ").map { it.toInt() }
    val positions = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getMaxD(s, positions))
}

private fun getMaxD(s: Int, positions: IntArray) =
    positions.map { abs(it - s) }
        .reduce { acc, i -> gcd(acc, i) }

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}
