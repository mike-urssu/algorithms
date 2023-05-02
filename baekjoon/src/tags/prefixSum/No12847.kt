package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/12847
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val pays = readln().split(" ").map { it.toLong() }.toLongArray()
    val prefixSum = pays.runningFold(0, Long::plus)
    val max = (m..n).maxOf { i -> prefixSum[i] - prefixSum[i - m] }
    println(max)
}
