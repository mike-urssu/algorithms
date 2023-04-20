package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/14465
 */
fun main() {
    val (n, k, b) = readln().split(" ").map { it.toInt() }
    val trafficLights = IntArray(n)
    repeat(b) {
        val index = readln().toInt()
        trafficLights[index - 1] = 1
    }

    val prefixSum = trafficLights.runningFold(0, Int::plus)
    val min = (0..n - k)
        .minOf { i -> prefixSum[i + k] - prefixSum[i] }
    println(min)
}
