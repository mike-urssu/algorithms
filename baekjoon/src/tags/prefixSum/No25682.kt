package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/25682
 */
fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln().toCharArray() }

    val blackFirstGraph = parseGraph(n, m, graph, 'B')
    val blackFirstPrefixSum = getPrefixSum(n, m, blackFirstGraph)

    val whiteFirstGraph = parseGraph(n, m, graph, 'W')
    val whiteFirstPrefixSum = getPrefixSum(n, m, whiteFirstGraph)

    var min = Int.MAX_VALUE
    for (i in n downTo k) {
        for (j in m downTo k) {
            val count1 =
                blackFirstPrefixSum[i][j] - blackFirstPrefixSum[i - k][j] - blackFirstPrefixSum[i][j - k] + blackFirstPrefixSum[i - k][j - k]
            val count2 =
                whiteFirstPrefixSum[i][j] - whiteFirstPrefixSum[i - k][j] - whiteFirstPrefixSum[i][j - k] + whiteFirstPrefixSum[i - k][j - k]
            min = min.coerceAtMost(minOf(count1, count2))
        }
    }
    println(min)
}

private fun parseGraph(n: Int, m: Int, graph: Array<CharArray>, character: Char): Array<IntArray> {
    val newGraph = Array(n) { IntArray(m) }
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (((i + j) % 2 == 0 && graph[i][j] == character) || ((i + j) % 2 == 1 && graph[i][j] != character)) {
                newGraph[i][j] = 0
            } else {
                newGraph[i][j] = 1
            }
        }
    }
    return newGraph
}

private fun getPrefixSum(n: Int, m: Int, graph: Array<IntArray>): Array<IntArray> {
    val prefixSum = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n) {
        for (j in 1..m) {
            prefixSum[i][j] = graph[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1]
        }
    }
    return prefixSum
}
