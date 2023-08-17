package tags.prefix_sum

import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/17203
 */
fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val array = readln().split(" ").map { it.toInt() }
    val variation = IntArray(n)
    (1 until n).forEach { i -> variation[i] = abs(array[i] - array[i - 1]) }
    val prefixSum = variation.runningFold(0, Int::plus)

    repeat(q) {
        val (i, j) = readln().split(" ").map { it.toInt() }
        if (j - 1 < i) {
            println(0)
        } else {
            println(prefixSum[j] - prefixSum[i])
        }
    }
}
