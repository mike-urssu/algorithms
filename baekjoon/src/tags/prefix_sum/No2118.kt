package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/2118
 */
fun main() {
    val n = readln().toInt()
    val distances = IntArray(n) { readln().toInt() }
    val totalDistance = distances.sum()

    val prefixSum = distances.runningFold(0, Int::plus)
    var max = Int.MIN_VALUE
    for (i in 1 until n) {
        for (j in i + 1 until n + 1) {
            val distance = prefixSum[j] - prefixSum[i]
            max = max.coerceAtLeast(minOf(distance, totalDistance - distance))
        }
    }
    println(max)
}
