package tags.binary_search

/**
 * https://www.acmicpc.net/problem/3079
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val times = IntArray(n) { readln().toInt() }
    println(getLeastTime(times, m))
}

private fun getLeastTime(times: IntArray, m: Int): Long {
    var low = 0L
    var high = 1000000000 * 1000000000L
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (isValid(times, mid, m)) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun isValid(times: IntArray, time: Long, m: Int): Boolean {
    var sum = 0L
    for (t in times) {
        sum += time / t
        if (sum >= m) {
            return true
        }
    }
    return false
}
