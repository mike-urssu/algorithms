package tags.binary_search

/**
 * https://www.acmicpc.net/problem/12015
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getLCSLength(n, numbers))
}

private fun getLCSLength(n: Int, numbers: IntArray): Int {
    val lcs = mutableListOf(0)
    for (i in 0 until n) {
        val lowerBound = getLowerBound(lcs, numbers[i])
        if (lcs.size == lowerBound) {
            lcs.add(numbers[i])
        } else {
            lcs[lowerBound] = numbers[i]
        }
    }
    return lcs.size - 1
}

private fun getLowerBound(lcs: List<Int>, n: Int): Int {
    var low = -1
    var high = lcs.size
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (lcs[mid] >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
