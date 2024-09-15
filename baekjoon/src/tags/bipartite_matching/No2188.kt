package tags.bipartite_matching

/**
 * https://www.acmicpc.net/problem/2188
 */
private lateinit var cows: IntArray
private lateinit var barns: IntArray
private lateinit var graph: Array<List<Int>>
private lateinit var isVisited: BooleanArray
private var count = 0

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    cows = IntArray(n + 1)
    barns = IntArray(m + 1)
    graph = getGraph(n)

    (1..n).forEach {
        isVisited = BooleanArray(n + 1)
        if (dfs(it)) {
            count++
        }
    }

    println(count)
}

private fun getGraph(n: Int): Array<List<Int>> {
    val graph = Array(n + 1) { listOf<Int>() }
    (1..n).forEach { graph[it] = readln().split(" ").map { it.toInt() }.drop(1) }
    return graph
}

private fun dfs(src: Int): Boolean {
    isVisited[src] = true
    graph[src].forEach { node ->
        if (barns[node] == 0 || (!isVisited[barns[node]] && dfs(barns[node]))) {
            cows[src] = node
            barns[node] = src
            return true
        }
    }
    return false
}
