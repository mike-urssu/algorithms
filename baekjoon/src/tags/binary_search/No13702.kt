package tags.binary_search

/**
 * https://www.acmicpc.net/problem/13702
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val capacities = IntArray(n) { readln().toInt() }
    println(findMax(capacities, k))
}

private fun findMax(capacities: IntArray, k: Int): Long {
    var low = 0L
    var high = Int.MAX_VALUE.toLong()
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (capacities.sumOf { it / mid } < k) {
            high = mid
        } else {
            low = mid
        }
    }
    return low
}
