package tags.sorting

/**
 * https://www.acmicpc.net/problem/2473
 */
import kotlin.math.absoluteValue

fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toLong() }.sorted().toLongArray()
    val solutions = findSolutions(numbers)
    println(solutions.joinToString(" "))
}

private fun findSolutions(numbers: LongArray): LongArray {
    val solutions = LongArray(3)
    var min = Long.MAX_VALUE
    (0 until numbers.size - 2).forEach { i ->
        var j = i + 1
        var k = numbers.lastIndex
        while (j < k) {
            val sum = numbers[i] + numbers[j] + numbers[k]
            if (sum.absoluteValue <= min) {
                solutions[0] = numbers[i]
                solutions[1] = numbers[j]
                solutions[2] = numbers[k]
                min = min.coerceAtMost(sum.absoluteValue)
            }

            if (sum <= 0) {
                j++
            } else {
                k--
            }
        }
    }
    return solutions
}
