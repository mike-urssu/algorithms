package tags.implementation

/**
 * https://www.acmicpc.net/problem/11558
 */
private var k = 0
private var n = 0
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isVisited: BooleanArray

fun main() {
    val t = readln().toInt()
    repeat(t) {
        n = readln().toInt()
        graph = getGraph(n)
        isVisited = BooleanArray(n + 1).apply { this[1] = true }
        k = 0
        dfs(1, 0)
        println(k)
    }
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    (1..n).forEach { i ->
        graph[i].add(readln().toInt())
    }
    return graph
}

private fun dfs(src: Int, depth: Int) {
    if (src == n) {
        k = depth
        return
    }

    graph[src].forEach { node ->
        if (!isVisited[node]) {
            isVisited[node] = true
            dfs(node, depth + 1)
            isVisited[node] = false
        }
    }
}
