package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/15724
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val prefixSum = getPrefixSum(n, m, graph)

    val k = readln().toInt()
    repeat(k) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        println(prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1])
    }
}

private fun getPrefixSum(n: Int, m: Int, graph: Array<IntArray>): Array<IntArray> {
    val prefixSum = Array(n + 1) { IntArray(m + 1) }
    (1..n).forEach { i ->
        (1..m).forEach { j ->
            prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + graph[i - 1][j - 1]
        }
    }
    return prefixSum
}
