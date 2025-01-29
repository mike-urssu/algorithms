package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/14921
 */
import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val solutions = readln().split(" ").map { it.toInt() }.toIntArray()

    var gap = Int.MAX_VALUE
    val indices = intArrayOf(0, n - 1)
    var left = 0
    var right = n - 1
    while (left < right) {
        val sum = abs(solutions[left] + solutions[right])
        if (sum < abs(gap)) {
            gap = sum
            indices[0] = left
            indices[1] = right
        }

        if (solutions[left] + solutions[right] < 0) {
            left++
        } else {
            right--
        }
    }
    println(indices.sumOf { solutions[it] })
}
