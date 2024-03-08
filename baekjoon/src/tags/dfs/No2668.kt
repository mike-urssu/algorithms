package tags.dfs

/**
 * https://www.acmicpc.net/problem/2668
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isVisited: BooleanArray
private var group = mutableListOf<Int>()

fun main() {
    val n = readln().toInt()
    graph = getGraph(n)

    (1..n).forEach { i ->
        isVisited = BooleanArray(n + 1)
        dfs(i, i)
    }

    println(group.size)
    group.sorted().forEach { println(it) }
}

private fun getGraph(n: Int) =
    Array(n + 1) { mutableListOf<Int>() }.apply {
        (1..n).forEach { this[it].add(readln().toInt()) }
    }

private fun dfs(src: Int, index: Int) {
    isVisited[index] = true

    graph[index].forEach { node ->
        if (src == node) {
            group.add(node)
            return
        }

        if (!isVisited[node]) {
            dfs(src, node)
        }
    }
}
