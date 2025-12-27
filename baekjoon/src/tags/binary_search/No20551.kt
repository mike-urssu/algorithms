package tags.binary_search

/**
 * https://www.acmicpc.net/problem/20551
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = IntArray(n) { readln().toInt() }
    val b = a.sortedArray()

    val set = b.toSet()
    repeat(m) {
        val d = readln().toInt()
        if (d !in set) {
            println(-1)
        } else {
            println(binarySearch(b, d))
        }
    }
}

private fun binarySearch(b: IntArray, d: Int): Int {
    var low = -1
    var high = b.lastIndex
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (d <= b[mid]) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
