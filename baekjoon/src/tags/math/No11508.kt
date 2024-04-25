package tags.math

/**
 * https://www.acmicpc.net/problem/11508
 */
fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { readln().toInt() }.sortedDescending()
    val sum = (0 until n).filterNot { it % 3 == 2 }.sumOf { numbers[it] }
    println(sum)
}
