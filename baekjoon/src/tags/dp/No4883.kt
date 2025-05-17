package tags.dp

/**
 * https://www.acmicpc.net/problem/4883
 */
fun main() {
    var i = 1
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }
        val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
        println("${i++}. ${getMin(n, graph)}")
    }
}

private fun getMin(n: Int, graph: Array<IntArray>): Int {
    val costs = Array(n) { IntArray(3) { 1_000_000 } }
    costs[0][1] = graph[0][1]
    costs[0][2] = graph[0][1] + graph[0][2]
    (1 until n).forEach { i ->
        costs[i][0] = graph[i][0] + minOf(costs[i - 1][0], costs[i - 1][1])
        costs[i][1] = graph[i][1] + minOf(costs[i - 1][0], costs[i - 1][1], costs[i - 1][2], costs[i][0])
        costs[i][2] = graph[i][2] + minOf(costs[i - 1][1], costs[i - 1][2], costs[i][1])
    }
    return costs.last()[1]
}
