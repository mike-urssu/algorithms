package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1654
 */
fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val lines = IntArray(k) { readln().toInt() }
    println(getMaxLength(lines, n))
}

private fun getMaxLength(lines: IntArray, n: Int): Long {
    var low = 0L
    var high = Long.MAX_VALUE
    while (low + 1 < high) {
        val mid = (low + high) / 2
        val count = lines.sumOf { it / mid }
        if (count < n) {
            high = mid
        } else {
            low = mid
        }
    }
    return low
}
