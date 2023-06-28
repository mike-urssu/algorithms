package tags.dp

/**
 * https://www.acmicpc.net/problem/11054
 */
fun main() {
    readln()
    val sequence = readln().split(" ").map { it.toInt() }.toIntArray()
    val increasingSequence = getIncreasingSequence(sequence)
    val decreasingSequence = getDecreasingSequence(sequence)
    val max = sequence.indices.maxOf { i -> increasingSequence[i] + decreasingSequence[i] - 1 }
    println(max)
}

private fun getIncreasingSequence(sequence: IntArray): IntArray {
    val dp = IntArray(sequence.size) { 1 }
    for (i in 1 until sequence.size) {
        for (j in i - 1 downTo 0) {
            if (sequence[i] > sequence[j]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
        }
    }
    return dp
}

private fun getDecreasingSequence(sequence: IntArray): IntArray {
    val dp = IntArray(sequence.size) { 1 }
    for (i in sequence.lastIndex - 1 downTo 0) {
        for (j in i + 1 until sequence.size) {
            if (sequence[i] > sequence[j]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
        }
    }
    return dp
}
