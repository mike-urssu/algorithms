package tags.floyd_warshall

/**
 * https://www.acmicpc.net/problem/1613
 */
private lateinit var graph: Array<BooleanArray>

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, k)

    val s = readln().toInt()
    repeat(s) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        val order = if (graph[src][dst]) {
            -1
        } else if (graph[dst][src]) {
            1
        } else {
            0
        }
        println(order)
    }
}

private fun getGraph(n: Int, k: Int): Array<BooleanArray> {
    val graph = Array(n + 1) { BooleanArray(n + 1) }
    (1..n).forEach { i -> graph[i][i] = true }
    repeat(k) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        graph[src][dst] = true
    }

    (1..n).forEach { via ->
        (1..n).forEach { i ->
            (1..n).forEach { j ->
                if (graph[i][via] && graph[via][j]) {
                    graph[i][j] = true
                }
            }
        }
    }

    return graph
}
