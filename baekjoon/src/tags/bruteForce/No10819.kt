package tags.bruteForce

import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/10819
 */
private var max = Int.MIN_VALUE

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val permutation = IntArray(n)
    val isVisited = BooleanArray(n)

    permutation(numbers, permutation, isVisited, n, 0)

    println(max)
}

private fun permutation(numbers: List<Int>, permutation: IntArray, isVisited: BooleanArray, n: Int, index: Int) {
    if (index == n) {
        max = max.coerceAtLeast(calculate(permutation))
        return
    }

    for (i in isVisited.indices) {
        if (!isVisited[i]) {
            permutation[index] = numbers[i]
            isVisited[i] = true
            permutation(numbers, permutation, isVisited, n, index + 1)
            isVisited[i] = false
        }
    }
}

private fun calculate(permutation: IntArray) =
    (0 until permutation.size - 1)
        .sumOf { abs(permutation[it] - permutation[it + 1]) }
