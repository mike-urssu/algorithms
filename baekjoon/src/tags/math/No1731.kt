package tags.math

/**
 * https://www.acmicpc.net/problem/1731
 */
fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { readln().toInt() }
    val next = if (isArithmeticSequence(n, numbers)) {
        numbers.last() + (numbers[n - 1] - numbers[n - 2])
    } else {
        numbers.last() * (numbers[n - 1] / numbers[n - 2])
    }
    println(next)
}

private fun isArithmeticSequence(n: Int, numbers: IntArray): Boolean {
    val gap = numbers[1] - numbers[0]
    return (2 until n).all { i -> numbers[i] - numbers[i - 1] == gap }
}
