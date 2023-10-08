package tags.binary_search

/**
 * https://www.acmicpc.net/problem/7795
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val a = readln().split(" ").map { it.toInt() }.toIntArray()
        val b = readln().split(" ").map { it.toInt() }.toIntArray().sortedArray()
        val count = a.sumOf { getLowerBound(b, it) }
        println(count)
    }
}

private fun getLowerBound(numbers: IntArray, n: Int): Int {
    var low = -1
    var high = numbers.size
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers[mid] > n) {
            high = mid
        } else if (numbers[mid] == n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
