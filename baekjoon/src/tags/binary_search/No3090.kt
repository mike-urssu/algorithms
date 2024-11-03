package tags.binary_search

/**
 * https://www.acmicpc.net/problem/3090
 */
import kotlin.math.abs

fun main() {
    val (n, t) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    var low = -1
    var high = (0 until n - 1).maxOf { i -> abs(numbers[i] - numbers[i + 1]) }
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (calibrate(n, numbers.clone(), mid) <= t) {
            high = mid
        } else {
            low = mid
        }
    }

    calibrate(n, numbers, high)
    println(numbers.joinToString(" "))
}

private fun calibrate(n: Int, numbers: IntArray, gap: Int): Long {
    var d = 0L
    for (i in 0 until n - 1) {
        val diff = abs(numbers[i] - numbers[i + 1])
        if (diff > gap) {
            if (numbers[i] > numbers[i + 1]) {
                numbers[i] -= diff - gap
            } else {
                numbers[i + 1] -= diff - gap
            }
            d += diff - gap
        }
    }

    for (i in n - 2 downTo 0) {
        val diff = abs(numbers[i] - numbers[i + 1])
        if (diff > gap) {
            if (numbers[i] > numbers[i + 1]) {
                numbers[i] -= diff - gap
            } else {
                numbers[i + 1] -= diff - gap
            }
            d += diff - gap
        }
    }
    return d
}
