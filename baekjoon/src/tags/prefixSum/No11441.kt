package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/11441
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val prefixSum = getPrefixSum(n, numbers)

    val m = readln().toInt()
    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() }
        println("${prefixSum[j] - prefixSum[i - 1]}")
    }
}

private fun getPrefixSum(n: Int, numbers: List<Int>): IntArray {
    val prefixSum = IntArray(n + 1)
    (1..n).forEach { i -> prefixSum[i] = prefixSum[i - 1] + numbers[i - 1] }
    return prefixSum
}
