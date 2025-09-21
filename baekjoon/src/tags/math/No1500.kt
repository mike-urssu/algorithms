package tags.math

/**
 * https://www.acmicpc.net/problem/1500
 */
fun main() {
    val (s, n) = readln().split(" ").map { it.toInt() }

    var remainder = s - n
    val numbers = LongArray(n) { 1 }
    var i = 0
    while (remainder > 0) {
        numbers[i]++
        remainder--
        i = (i + 1) % n
    }

    val mul = numbers.reduce { acc, v -> acc * v }
    println(mul)
}
