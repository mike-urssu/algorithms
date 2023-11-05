package tags.dp

/**
 * https://www.acmicpc.net/problem/17404
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    println(getCost(n))
}

private fun getCost(n: Int): Int {
    var min = Int.MAX_VALUE
    val costs = Array(n) { IntArray(3) }

    for (color in 0 until 3) {
        for (j in 0 until 3) {
            costs[0][j] = if (color == j) {
                Int.MAX_VALUE
            } else {
                graph[0][j]
            }
        }

        (1 until n).forEach { i ->
            costs[i][0] = minOf(costs[i - 1][1], costs[i - 1][2]) + graph[i][0]
            costs[i][1] = minOf(costs[i - 1][0], costs[i - 1][2]) + graph[i][1]
            costs[i][2] = minOf(costs[i - 1][0], costs[i - 1][1]) + graph[i][2]
        }

        min = min.coerceAtMost(costs.last()[color])
    }
    return min
}
