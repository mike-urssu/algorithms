package tags.dfs

/**
 * https://www.acmicpc.net/problem/11725
 */
private lateinit var graph: MutableList<MutableList<Int>>
private lateinit var parents: IntArray

fun main() {
    val n = readln().toInt()
    graph = mutableListOf()
    parents = IntArray(n + 1)

    repeat(n + 1) { graph.add(mutableListOf()) }
    repeat(n - 1) {
        val (s, d) = readln().split(" ").map { it.toInt() }
        graph[s].add(d)
        graph[d].add(s)
    }

    (1..n).forEach {
        if (parents[it] == 0) {
            dfs(it)
        }
    }

    (2..n).forEach { println(parents[it]) }
}

private fun dfs(index: Int) {
    for (n in graph[index]) {
        if (parents[n] == 0) {
            parents[n] = index
            dfs(n)
        }
    }
}
