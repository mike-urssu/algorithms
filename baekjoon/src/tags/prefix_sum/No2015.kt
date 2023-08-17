package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/2015
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }
    val array = readln().split(" ").map { it.toLong() }.toLongArray()
    val prefixSum = array.runningFold(0, Long::plus)

    val map = mutableMapOf<Long, Long>()
    var count = (1..n).count { prefixSum[it.toInt()] == k }.toLong()
    (1..n).forEach { i ->
        count += map[prefixSum[i.toInt()] - k] ?: 0L
        map[prefixSum[i.toInt()]] = (map[prefixSum[i.toInt()]] ?: 0) + 1
    }
    println(count)
}
