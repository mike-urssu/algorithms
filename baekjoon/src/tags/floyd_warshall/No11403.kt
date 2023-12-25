package tags.floyd_warshall

/**
 * https://www.acmicpc.net/problem/11403
 */
fun main() {
    val n = readln().toInt()
    val graph = getGraph(n)
    graph.forEach { println(it.joinToString(" ")) }
}

private fun getGraph(n: Int): Array<IntArray> {
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    (0 until n).forEach { k ->
        (0 until n).forEach { i ->
            (0 until n).forEach { j ->
                if (graph[i][k] == 1 && graph[k][j] == 1) {
                    graph[i][j] = 1
                }
            }
        }
    }
    return graph
}
