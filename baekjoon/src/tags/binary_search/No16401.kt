package tags.binary_search

/**
 * https://www.acmicpc.net/problem/16401
 */
fun main() {
    val (m, _) = readln().split(" ").map { it.toInt() }
    val lengths = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getMaxLength(lengths, m))
}

private fun getMaxLength(lengths: IntArray, m: Int): Int {
    var low = 0
    var high = 1000000001
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (lengths.sumOf { it / mid } < m) {
            high = mid
        } else {
            low = mid
        }
    }
    return low
}
