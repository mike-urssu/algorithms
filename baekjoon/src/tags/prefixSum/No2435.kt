package tags.prefixSum

import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2435
 */
fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val k = scanner.nextInt()
    val temperatures = IntArray(n) { scanner.nextInt() }
    val prefixSum = temperatures.runningFold(0, Int::plus)
    val max = (k..n).maxOf { i -> prefixSum[i] - prefixSum[i - k] }
    println(max)
}
