package tags.dfs

/**
 * https://www.acmicpc.net/problem/24480
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var orders: IntArray
private var order = 1

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)
    orders = IntArray(n + 1)

    dfs(r)

    (1..n).forEach { println(orders[it]) }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    graph.forEach { it.sortDescending() }
    return graph
}

private fun dfs(n: Int) {
    orders[n] = order++
    graph[n].forEach { i ->
        if (orders[i] == 0) {
            dfs(i)
        }
    }
}
