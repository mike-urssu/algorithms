package tags.binary_search

/**
 * https://www.acmicpc.net/problem/3745
 */
import java.util.StringTokenizer

fun main() {
    while (true) {
        val n = (readlnOrNull() ?: break).trim().toInt()
        val prices = getPrices(n)
        println(getLCSLength(prices))
    }
}

private fun getPrices(n: Int): IntArray {
    val tokens = StringTokenizer(readln().trim())
    return IntArray(n) {
        tokens.nextToken().toInt()
    }
}

private fun getLCSLength(numbers: IntArray): Int {
    val lcs = mutableListOf(0)
    numbers.forEach { n ->
        val lowerBound = getLowerBound(lcs, n)
        if (lowerBound == lcs.size) {
            lcs.add(n)
        } else {
            lcs[lowerBound] = n
        }
    }
    return lcs.size - 1
}

private fun getLowerBound(numbers: List<Int>, n: Int): Int {
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
