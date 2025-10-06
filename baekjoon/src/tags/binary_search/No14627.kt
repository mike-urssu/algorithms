package tags.binary_search

/**
 * https://www.acmicpc.net/problem/14627
 */
fun main() {
    val (s, c) = readln().split(" ").map { it.toInt() }
    val lengths = LongArray(s) { readln().toLong() }
    val length = binarySearch(lengths, c)
    println(lengths.sum() - length * c.toLong())
}

private fun binarySearch(numbers: LongArray, n: Int): Int {
    var low = 0
    var high = 1_000_000_001
    while (low + 1 < high) {
        val mid = (low + high) / 2
        val sum = numbers.sumOf { it / mid }
        if (sum >= n) {
            low = mid
        } else {
            high = mid
        }
    }
    return low
}
