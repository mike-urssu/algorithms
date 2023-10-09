package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2473
 */
import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toLong() }.sorted().toLongArray()
    println(findSolutions(n, numbers).joinToString(" "))
}

private fun findSolutions(n: Int, numbers: LongArray): LongArray {
    val solutions = LongArray(3) { 1000000001L }
    var min = abs(solutions.sum())
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            val k = getLowerBound(numbers, -(numbers[i] + numbers[j]), j)
            if (k - 1 > j && abs(numbers[i] + numbers[j] + numbers[k - 1]) < min) {
                solutions[0] = numbers[i]
                solutions[1] = numbers[j]
                solutions[2] = numbers[k - 1]
                min = abs(solutions.sum())
            }
            if (k > j && abs(numbers[i] + numbers[j] + numbers[k]) < min) {
                solutions[0] = numbers[i]
                solutions[1] = numbers[j]
                solutions[2] = numbers[k]
                min = abs(solutions.sum())
            }
        }
    }
    return solutions
}

private fun getLowerBound(numbers: LongArray, n: Long, from: Int): Int {
    var low = from
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
