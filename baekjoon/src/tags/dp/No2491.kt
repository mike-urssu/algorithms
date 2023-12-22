package tags.dp

/**
 * https://www.acmicpc.net/problem/2491
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val length1 = getIncreasingSequenceLength(n, numbers)
    val length2 = getDecreasingSequenceLength(n, numbers)
    println(length1.coerceAtLeast(length2))
}

private fun getIncreasingSequenceLength(n: Int, numbers: IntArray): Int {
    val dp = IntArray(n) { 1 }
    (1 until n).forEach { i ->
        if (numbers[i] >= numbers[i - 1]) {
            dp[i] = dp[i - 1] + 1
        }
    }
    return dp.max()
}

private fun getDecreasingSequenceLength(n: Int, numbers: IntArray): Int {
    val dp = IntArray(n) { 1 }
    (1 until n).forEach { i ->
        if (numbers[i] <= numbers[i - 1]) {
            dp[i] = dp[i - 1] + 1
        }
    }
    return dp.max()
}
