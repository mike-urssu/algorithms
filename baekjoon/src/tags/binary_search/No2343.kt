package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2343
 */
fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val minutes = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getLeastSize(m, minutes))
}

private fun getLeastSize(m: Int, minutes: IntArray): Int {
    var low = 0
    var high = 1000000000
    while (low + 1 < high) {
        val mid = (low + high) shr 1
        if (minutes.any { it > mid }) {
            low = mid
            continue
        }

        val chunk = chunk(minutes, mid)
        if (chunk <= m) {
            high = mid
        } else {
            low = mid
        }
    }
    return high
}

private fun chunk(minutes: IntArray, chunkSize: Int): Int {
    var chunk = 1
    var sum = 0
    for (m in minutes) {
        if (sum + m <= chunkSize) {
            sum += m
        } else {
            sum = m
            chunk++
        }
    }
    return chunk
}
