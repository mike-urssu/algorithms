package tags.dp

/**
 * https://www.acmicpc.net/problem/14002
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    val indices = IntArray(n) { it }
    val dp = getSequences(n, numbers, indices)
    val increasingSequence = getIncreasingSequence(numbers, dp, indices)

    println(dp.max())
    println(increasingSequence.joinToString(" "))
}

private fun getSequences(n: Int, numbers: IntArray, indices: IntArray): IntArray {
    val dp = IntArray(n) { 1 }
    for (i in numbers.indices) {
        for (j in 0 until i) {
            if (numbers[i] > numbers[j] && dp[j] >= dp[i]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
                indices[i] = j
            }
        }
    }
    return dp
}

private fun getIncreasingSequence(numbers: IntArray, dp: IntArray, indices: IntArray): List<Int> {
    var index = dp.indexOf(dp.max())
    val sequence = mutableListOf<Int>()
    while (index != indices[index]) {
        sequence.add(numbers[index])
        index = indices[index]
    }
    sequence.add(numbers[index])
    return sequence.reversed()
}
