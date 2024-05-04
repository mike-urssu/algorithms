package tags.dfs

/**
 * https://www.acmicpc.net/problem/1058
 */
private var n = 0
private lateinit var graph: Array<MutableList<Int>>
private lateinit var friends: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    n = readln().toInt()
    graph = getGraph()
    friends = IntArray(n)
    (0 until n).forEach { i ->
        isVisited = BooleanArray(n)
        isVisited[i] = true
        dfs(i, i, 0)
    }
    println(friends.max())
}

private fun getGraph(): Array<MutableList<Int>> {
    val graph = Array(n) { mutableListOf<Int>() }
    repeat(n) { i ->
        val s = readln().toCharArray()
        val friends = (0 until n).filter { j -> s[j] == 'Y' }
        graph[i].addAll(friends)
    }
    return graph
}

private fun dfs(src: Int, index: Int, depth: Int) {
    if (depth == 2) {
        return
    }

    graph[index].forEach { node ->
        if (!isVisited[node]) {
            isVisited[node] = true
            friends[src]++
        }
        dfs(src, node, depth + 1)
    }
}
