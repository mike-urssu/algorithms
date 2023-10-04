package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2470
 */
import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    println(getSolutions(n, numbers).joinToString(" "))
}

private fun getSolutions(n: Int, numbers: IntArray): IntArray {
    val solutions = IntArray(2) { 1000000001 }
    for (i in 0 until numbers.lastIndex) {
        val j = getOtherSolution(n, numbers, i)
        if (isCloserToZero(numbers, i, j, solutions)) {
            solutions[0] = numbers[i]
            solutions[1] = numbers[j]
        }
        if (i != j - 1 && isCloserToZero(numbers, i, j - 1, solutions)) {
            solutions[0] = numbers[i]
            solutions[1] = numbers[j - 1]
        }
    }
    return solutions
}

private fun getOtherSolution(n: Int, numbers: IntArray, index: Int): Int {
    var low = index
    var high = n - 1
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (-numbers[index] <= numbers[mid]) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun isCloserToZero(numbers: IntArray, i: Int, j: Int, solutions: IntArray) =
    abs(numbers[i] + numbers[j]) < abs(solutions.sum())
