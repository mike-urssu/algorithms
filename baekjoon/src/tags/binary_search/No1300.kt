package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1300
 */
fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    println(getKthNumber(n, k))
}

private fun getKthNumber(n: Int, k: Int): Int {
    var low = 0
    var high = 1000000000
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if ((1..n).sumOf { minOf(n, mid / it) } >= k) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
