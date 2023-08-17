package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/9527
 */
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    println("${f(b) - f(a - 1)}")
}

private val prefixSum = getPrefixSum()

private fun getPrefixSum(): LongArray {
    val prefixSum = LongArray(55)
    prefixSum[1] = 1
    (2 until prefixSum.size).forEach { i -> prefixSum[i] = prefixSum[i - 1] * 2 + (1L shl i - 1) }
    return prefixSum
}

private fun f(x: Long): Long {
    var count = 0L
    var n = x
    for (i in 54 downTo 0) {
        val s = 1L shl i
        if (n.and(s) != 0L) {
            count += prefixSum[i] + (n - s + 1)
            n -= s
        }
    }
    return count
}
