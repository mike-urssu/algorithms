package tags.tree

/**
 * https://www.acmicpc.net/problem/1949
 */
private lateinit var populations: IntArray
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isVisited: BooleanArray

fun main() {
    val n = readln().toInt()
    populations = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    graph = getGraph(n)
    isVisited = BooleanArray(n + 1)

    println(sum(n))
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        graph[src].add(dst)
        graph[dst].add(src)
    }
    return graph
}

private fun sum(n: Int): Int {
    val sum = Array(n + 1) { IntArray(2) }
    dfs(sum, 1)
    return sum[1].max()
}

private fun dfs(sum: Array<IntArray>, src: Int) {
    isVisited[src] = true
    sum[src][0] = 0
    sum[src][1] = populations[src]

    graph[src].forEach { node ->
        if (!isVisited[node]) {
            dfs(sum, node)

            sum[src][0] += maxOf(sum[node][0], sum[node][1])
            sum[src][1] += sum[node][0]
        }
    }
}
