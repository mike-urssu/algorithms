package tags.bruteForce

import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/1107
 */
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val invalidNumbers = if (m == 0) {
        emptySet()
    } else {
        readln().split(" ").map { it.toInt() }.toSet()
    }

    var min = abs(n - 100)
    for (number in 0..999999) {
        val digits = number.toString().toCharArray()
        if (digits.all { !invalidNumbers.contains(it.digitToInt()) }) {
            min = min.coerceAtMost(digits.size + abs(n - number))
        }
    }
    println(min)
}
