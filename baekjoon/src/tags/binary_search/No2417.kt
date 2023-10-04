package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2417
 */
fun main() {
    val n = readln().toLong()
    println(sqrt(n))
}

private fun sqrt(n: Long): Long {
    var low = -1L
    var high = 3037000500L
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (mid * mid >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}
