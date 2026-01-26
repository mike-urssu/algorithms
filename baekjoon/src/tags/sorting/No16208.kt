package tags.sorting

/**
 * https://www.acmicpc.net/problem/16208
 */
fun main() {
    val n = readln().toInt()
    val lengths = readln().split(" ").map { it.toLong() }.sorted().toLongArray()
    val prefixSum = lengths.runningFold(0, Long::plus)
    val sum = (n downTo 1).sumOf { i -> (prefixSum[i] - prefixSum[i - 1]) * prefixSum[i - 1] }
    println(sum)
}
