package tags.dp

/**
 * https://www.acmicpc.net/problem/14494
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = getGraph()
    println(graph[n][m])
}

private fun getGraph(): Array<LongArray> {
    val graph = Array(1001) { LongArray(1001) }
    val mod = 1_000_000_007
    (1..1000).forEach { j -> graph[1][j] = 1 }
    (1..1000).forEach { i -> graph[i][1] = 1 }
    (2..1000).forEach { i ->
        (2..1000).forEach { j ->
            graph[i][j] = (graph[i - 1][j - 1] + graph[i][j - 1] + graph[i - 1][j]) % mod
        }
    }
    return graph
}
