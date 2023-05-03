package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/12841
 */
fun main() {
    val n = readln().toInt()
    val crosses = readln().split(" ").map { it.toLong() }
    val leftPrefixSum = readln().split(" ").map { it.toLong() }.runningFold(0, Long::plus)
    val rightPrefixSum = readln().split(" ").map { it.toLong() }.runningFold(0, Long::plus)

    var minIndex = 0
    var minDistance = Long.MAX_VALUE
    for (i in 0 until n) {
        val distance =
            (leftPrefixSum[i] - leftPrefixSum.first()) + crosses[i] + (rightPrefixSum.last() - rightPrefixSum[i])
        if (distance < minDistance) {
            minIndex = i + 1
            minDistance = distance
        }
    }

    println("$minIndex $minDistance")
}
