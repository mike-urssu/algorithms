package tags.prefix_sum

import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/2851
 */
fun main() {
    val numbers = IntArray(10) { readln().toInt() }
    val prefixSum = getPrefixSum(numbers)

    var n = Int.MAX_VALUE
    (1..10).forEach {
        if (abs(100 - prefixSum[it]) <= abs(100 - n)) {
            n = prefixSum[it]
        }
    }
    println(n)
}

private fun getPrefixSum(numbers: IntArray): IntArray {
    val prefixSum = IntArray(11)
    (1..10).forEach { i -> prefixSum[i] = prefixSum[i - 1] + numbers[i - 1] }
    return prefixSum
}
