package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/21921
 */
fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    val prefixSum = getPrefixSum(n, x, numbers)
    if (prefixSum.all { it == 0 }) {
        println("SAD")
    } else {
        val max = prefixSum.max()
        println(max)
        println(prefixSum.count { it == max })
    }
}

private fun getPrefixSum(n: Int, x: Int, numbers: IntArray): IntArray {
    val prefixSum = IntArray(n - x + 1)
    prefixSum[0] = numbers.take(x).sum()
    (1 until prefixSum.size).forEach { i -> prefixSum[i] = prefixSum[i - 1] - numbers[i - 1] + numbers[i + x - 1] }
    return prefixSum
}
