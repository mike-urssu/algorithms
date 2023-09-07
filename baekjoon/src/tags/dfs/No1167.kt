package tags.dfs

/**
 * https://www.acmicpc.net/problem/1167
 */
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private lateinit var isVisited: BooleanArray

private var maxNode = 0
private var maxDistance = 0

fun main() {
    val v = readln().toInt()
    graph = getGraph(v)

    isVisited = BooleanArray(v + 1)
    dfs(1, 0)

    isVisited = BooleanArray(v + 1)
    dfs(maxNode, 0)

    println(maxDistance)
}

private fun getGraph(v: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(v + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(v) {
        val numbers = readln().split(" ").map { it.toInt() }
        val src = numbers[0]
        for (i in 0 until numbers.size / 2 - 1) {
            val dst = numbers[(i + 1) * 2 - 1]
            val distance = numbers[(i + 1) * 2]
            graph[src].add(Pair(dst, distance))
        }
    }
    return graph
}

private fun dfs(node: Int, distance: Int) {
    if (isVisited[node]) {
        return
    }

    if (distance > maxDistance) {
        maxNode = node
        maxDistance = distance
    }

    isVisited[node] = true
    for (pair in graph[node]) {
        dfs(pair.first, pair.second + distance)
    }
}
