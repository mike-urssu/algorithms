package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/14465
 */
fun main() {
    val (n, k, b) = readln().split(" ").map { it.toInt() }
    val trafficLights = IntArray(n + 1)
    repeat(b) {
        val index = readln().toInt()
        trafficLights[index] = 1
    }
    (1..n).forEach { i -> trafficLights[i] += trafficLights[i - 1] }

    val min = (0..n - k)
        .minOf { i -> trafficLights[i + k] - trafficLights[i] }
    println(min)
}
