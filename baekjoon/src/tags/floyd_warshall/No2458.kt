package tags.floyd_warshall

/**
 * https://www.acmicpc.net/problem/2458
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = getGraph(n, m)
    val count = (1..n).count { i ->
        (1..n).count { j -> graph[i][j][0] || graph[i][j][1] } == n - 1
    }
    println(count)
}

private fun getGraph(n: Int, m: Int): Array<Array<BooleanArray>> {
    val graph = Array(n + 1) { Array(n + 1) { BooleanArray(2) } }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a][b][0] = true
        graph[b][a][1] = true
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (graph[i][k][0] && graph[k][j][0]) {
                    graph[i][j][0] = true
                }
                if (graph[i][k][1] && graph[k][j][1]) {
                    graph[i][j][1] = true
                }
            }
        }
    }

    return graph
}
