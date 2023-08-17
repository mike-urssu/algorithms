package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/21758
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val prefixSum = getPrefixSum(n, numbers)

    val a = (2 until n)
        .maxOf { i -> (prefixSum.last() - prefixSum[1] - numbers[i - 1]) + (prefixSum.last() - prefixSum[i]) }
    val b = (2 until n)
        .maxOf { i -> (prefixSum[i] - prefixSum[1]) + (prefixSum[n - 1] - prefixSum[i - 1]) }
    val c = (2 until n)
        .maxOf { i -> prefixSum[i - 1] + (prefixSum[n - 1] - numbers[i - 1]) }

    println(maxOf(a, b, c))
}

private fun getPrefixSum(n: Int, numbers: List<Int>): IntArray {
    val prefixSum = IntArray(n + 1)
    (1..n).forEach { i -> prefixSum[i] = prefixSum[i - 1] + numbers[i - 1] }
    return prefixSum
}
