package tags.binary_search

/**
 * https://www.acmicpc.net/problem/16564
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val levels = LongArray(n) { readln().toLong() }.sortedArray()

    var low = levels.min()
    var high = low + k + 1
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (isValid(levels, k, mid)) {
            low = mid
        } else {
            high = mid
        }
    }
    println(low)
}

private fun isValid(levels: LongArray, k: Int, mid: Long): Boolean {
    val sum = levels.sumOf { maxOf(mid - it, 0) }
    return sum <= k
}
