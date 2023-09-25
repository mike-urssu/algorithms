package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2805
 */
fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val heights = readln().split(" ").map { it.toLong() }.toLongArray()
    println(getMaxHeight(heights, m))
}

private fun getMaxHeight(heights: LongArray, m: Int): Long {
    var low = 0L
    var high = 2000000000L
    while (low + 1 < high) {
        val mid = (low + high) / 2
        val k = heights.sumOf { maxOf(it - mid, 0) }
        if (k < m) {
            high = mid
        } else {
            low = mid
        }
    }
    return low
}
