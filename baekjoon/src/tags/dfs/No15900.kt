package tags.dfs

/**
 * https://www.acmicpc.net/problem/15900
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isVisited: BooleanArray
private var sum = 0

fun main() {
    val n = readln().toInt()
    graph = getGraph(n)
    isVisited = BooleanArray(n + 1)

    dfs(1, 0)

    if (sum % 2 == 1) {
        println("Yes")
    } else {
        println("No")
    }
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    return graph
}

private fun dfs(node: Int, distance: Int) {
    var isLeaf = true
    isVisited[node] = true
    for (child in graph[node]) {
        if (!isVisited[child]) {
            isLeaf = false
            dfs(child, distance + 1)
        }
    }

    if (isLeaf) {
        sum += distance
    }
}
