package tags.floyd_warshall

/**
 * https://www.acmicpc.net/problem/2617
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = getGraph(n, m)

    val mid = (n + 1) shr 1
    val count = (1..n).count { k ->
        val countLight = graph[k].count { it }
        val countHeavy = (1..n).count { i -> graph[i][k] }
        countLight >= mid || countHeavy >= mid
    }
    println(count)
}

private fun getGraph(n: Int, m: Int): Array<BooleanArray> {
    val graph = Array(n + 1) { BooleanArray(n + 1) }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a][b] = true
    }
    (1..n).forEach { k ->
        (1..n).forEach { i ->
            (1..n).forEach { j ->
                graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j])
            }
        }
    }
    return graph
}
