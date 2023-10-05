package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2467
 */
import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getSolutions(n, numbers).joinToString(" "))
}

private fun getSolutions(n: Int, numbers: IntArray): IntArray {
    val solutions = IntArray(2) { 1000000001 }
    for (i in 0 until n - 1) {
        val j = getLowerBound(numbers, i + 1, -numbers[i])
        if (abs(numbers[i] + numbers[j]) < abs(solutions.sum())) {
            solutions[0] = numbers[i]
            solutions[1] = numbers[j]
        }
        if (i != j - 1 && abs(numbers[i] + numbers[j - 1]) < abs(solutions.sum())) {
            solutions[0] = numbers[i]
            solutions[1] = numbers[j - 1]
        }
    }
    return solutions
}

private fun getLowerBound(numbers: IntArray, index: Int, n: Int): Int {
    var low = index
    var high = numbers.lastIndex
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (numbers[mid] >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
