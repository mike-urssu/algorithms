package tags.binary_search

/**
 * https://www.acmicpc.net/problem/3649
 */
import kotlin.math.abs

fun main() {
    while (true) {
        val x = (readlnOrNull() ?: break).toInt() * 10000000
        val n = readln().toInt()
        val lengths = IntArray(n) { readln().toInt() }.sortedArray()

        val (l1, l2) = getLengths(n, lengths, x)
        if (l1 == 0 && l2 == 0) {
            println("danger")
        } else {
            println("yes $l1 $l2")
        }
    }
}

private fun getLengths(n: Int, lengths: IntArray, x: Int): IntArray {
    var l1 = 0
    var l2 = 0
    for (i in lengths.indices) {
        val lowerBound = getLowerBound(lengths, x - lengths[i] + 1) - 1
        if (lowerBound in i + 1 until n && lengths[i] + lengths[lowerBound] == x) {
            if (abs(l1 - l2) <= abs(lengths[i] - lengths[lowerBound])) {
                l1 = lengths[i]
                l2 = lengths[lowerBound]
            }
        }
    }
    return intArrayOf(l1, l2)
}

private fun getLowerBound(numbers: IntArray, n: Int): Int {
    var low = -1
    var high = numbers.size
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
