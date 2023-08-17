package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/14929
 */
fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toLong() }
    val prefixSum = numbers.runningFold(0, Long::plus)

    val sum = (0 until numbers.lastIndex)
        .sumOf { i -> numbers[i] * (prefixSum.last() - prefixSum[i + 1]) }
    println(sum)
}
