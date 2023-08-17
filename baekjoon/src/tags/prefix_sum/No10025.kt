package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/10025
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val array = IntArray(1000001)
    repeat(n) {
        val (g, x) = readln().split(" ").map { it.toInt() }
        array[x] = g
    }

    val prefixSum = getPrefixSum(array)
    val max = prefixSum.indices
        .maxOf { i ->
            val left = (i - k - 1)
            val right = (i + k).coerceAtMost(1000000)
            if (left < 0) {
                prefixSum[right]
            } else {
                prefixSum[right] - prefixSum[left]
            }
        }
    println(max)
}

private fun getPrefixSum(numbers: IntArray): IntArray {
    val prefixSum = IntArray(1000001)
    prefixSum[0] = numbers[0]
    (1..1000000).forEach { i -> prefixSum[i] = prefixSum[i - 1] + numbers[i] }
    return prefixSum
}
