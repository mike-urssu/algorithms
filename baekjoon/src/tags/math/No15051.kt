package tags.math

/**
 * https://www.acmicpc.net/problem/15051
 */
fun main() {
    val numbers = IntArray(3) { readln().toInt() }
    val minute = minOf(numbers[1] * 2 + numbers[2] * 4, numbers[0] * 2 + numbers[2] * 2, numbers[0] * 4 + numbers[1] * 2)
    println(minute)
}
