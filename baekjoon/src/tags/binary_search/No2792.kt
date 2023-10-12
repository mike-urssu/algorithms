package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2792
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val counts = IntArray(m) { readln().toInt() }
    println(getMin(n, counts))
}

private fun getMin(n: Int, counts: IntArray): Int {
    var low = 0
    var high = 1000000000
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (counts.sumOf { (it + mid - 1) / mid } <= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
