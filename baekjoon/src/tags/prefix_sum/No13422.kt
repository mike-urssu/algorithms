package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/13422
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m, k) = readln().split(" ").map { it.toInt() }
        val moneys = readln().split(" ").map { it.toLong() }.toLongArray()
        val prefixSum = moneys.runningFold(0, Long::plus)
        println(countWays(n, m, k, prefixSum))
    }
}

private fun countWays(n: Int, m: Int, k: Int, prefixSum: List<Long>): Int {
    var count = 0
    if (n == m) {
        if (prefixSum[n] - prefixSum[0] < k) {
            count++
        }
    } else {
        count += (m..n).count { i -> prefixSum[i] - prefixSum[i - m] < k }
        count += (1 until m).count { i -> prefixSum[n] - prefixSum[n - m + i] + prefixSum[i] < k }
    }
    return count
}
