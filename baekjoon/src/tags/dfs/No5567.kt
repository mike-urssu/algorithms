package tags.dfs

/**
 * https://www.acmicpc.net/problem/5567
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var depths: IntArray

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    graph = getGraph(n, m)
    depths = IntArray(n + 1) { Int.MAX_VALUE }

    dfs(1, 0)

    println(depths.count { it <= 2 } - 1)
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    return graph
}

private fun dfs(src: Int, depth: Int) {
    depths[src] = depth

    graph[src].forEach { node ->
        if (depth < depths[node]) {
            dfs(node, depth + 1)
        }
    }
}
