package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/27496
 */
fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val range = 129..138
    val prefixSum = numbers.runningFold(0, Int::plus)
    var count = (1 until l).count { i -> prefixSum[i] in range }
    count += (l..n).count { i -> prefixSum[i] - prefixSum[i - l] in range }
    println(count)
}
