package tags.math

/**
 * https://www.acmicpc.net/problem/8558
 */
fun main() {
    val n = readln().toInt()
    val digits = intArrayOf(1, 1, 2, 6, 4)
    val digit = if (n in digits.indices) {
        digits[n]
    } else {
        0
    }
    println(digit)
}
