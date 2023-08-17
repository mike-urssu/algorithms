package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/13900
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toLong() }.toLongArray()

    val prefixSum = getPrefixSum(n, numbers)
    val sum = numbers.indices.sumOf { i -> numbers[i] * (prefixSum.last() - prefixSum[i + 1]) }
    println(sum)
}

private fun getPrefixSum(n: Int, numbers: LongArray): LongArray {
    val prefixSum = LongArray(n + 1)
    (1..n).forEach { i -> prefixSum[i] = prefixSum[i - 1] + numbers[i - 1] }
    return prefixSum
}
