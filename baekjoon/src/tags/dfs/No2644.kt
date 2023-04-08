package tags.dfs

/**
 * https://www.acmicpc.net/problem/2644
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isVisited: BooleanArray
private var depth = -1

fun main() {
    val n = readln().toInt()
    graph = Array(n + 1) { mutableListOf() }
    isVisited = BooleanArray(n + 1)
    val (src, dest) = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }

    dfs(src, dest, 0)

    println(depth)
}

private fun dfs(index: Int, dest: Int, d: Int) {
    if (index == dest) {
        depth = d
        return
    }

    isVisited[index] = true
    for (n in graph[index]) {
        if (!isVisited[n]) {
            dfs(n, dest, d + 1)
        }
    }
}
