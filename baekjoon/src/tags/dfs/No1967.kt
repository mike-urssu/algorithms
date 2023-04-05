package tags.dfs

/**
 * https://www.acmicpc.net/problem/1967
 */
private lateinit var graph: Array<MutableList<Node>>
private lateinit var isVisited: BooleanArray
private var sum = 0
private var max = 0

fun main() {
    val n = readln().toInt()
    graph = Array(n + 1) { mutableListOf() }
    repeat(n - 1) {
        val (parent, child, weight) = readln().split(" ").map { it.toInt() }
        graph[parent].add(Node(child, weight))
        graph[child].add(Node(parent, weight))
    }

    (1..n).forEach {
        isVisited = BooleanArray(n + 1)
        sum = 0
        dfs(it)
    }
    println(max)
}

private class Node(val index: Int, val weight: Int)

private fun dfs(index: Int) {
    isVisited[index] = true

    for (n in graph[index]) {
        if (!isVisited[n.index]) {
            sum += n.weight
            max = max.coerceAtLeast(sum)
            dfs(n.index)
            sum -= n.weight
        }
    }
}
