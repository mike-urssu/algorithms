package tags.binary_search

/**
 * https://www.acmicpc.net/problem/1561
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val times = readln().split(" ").map { it.toLong() }.toLongArray()
    println(getNumber(n, m, times))
}

private fun getNumber(n: Int, m: Int, times: LongArray): Int {
    if (n <= m) {
        return n
    }
    val runningTime = getRunningTime(times, n - m)
    return getIndex(n.toLong(), times, runningTime)
}

private fun getRunningTime(times: LongArray, n: Int): Long {
    var low = 0L
    var high = 2000000000 * 10000L
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (times.sumOf { mid / it } >= n) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun getIndex(n: Long, times: LongArray, runningTime: Long): Int {
    var index = 0
    var order = times.sumOf { ((runningTime - 1) / it) + 1 }
    for (i in times.indices) {
        if (runningTime % times[i] == 0L) {
            order++
            if (order == n) {
                index = i
                break
            }
        }
    }
    return index + 1
}
