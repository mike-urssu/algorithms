package tags.math

/**
 * https://www.acmicpc.net/problem/10409
 */
fun main() {
    val (_, t) = readln().split(" ").map { it.toInt() }
    val times = readln().split(" ").map { it.toInt() }.toIntArray()
    val prefixSum = times.runningFold(0, Int::plus)
    println(prefixSum.indexOfLast { it <= t })
}
