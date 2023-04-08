package tags.dfs

/**
 * https://www.acmicpc.net/problem/1707
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isVisited: IntArray
private var isBipartiteGraph = true

fun main() {
    val k = readln().toInt()
    repeat(k) {
        val (v, e) = readln().split(" ").map { it.toInt() }
        graph = Array(v + 1) { mutableListOf() }
        repeat(e) {
            val (s, d) = readln().split(" ").map { it.toInt() }
            graph[s].add(d)
            graph[d].add(s)
        }
        isVisited = IntArray(v + 1)
        isBipartiteGraph = true

        for (i in isVisited.indices) {
            if (isVisited[i] == 0) {
                dfs(i, 1)
            }
        }

        if (isBipartiteGraph) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun dfs(index: Int, type: Int) {
    if (isVisited[index] == 0) {
        isVisited[index] = type
    }

    for (n in graph[index]) {
        if (isVisited[n] == 0) {
            if (type == 1) {
                dfs(n, 2)
            } else {
                dfs(n, 1)
            }
        } else {
            if (type == isVisited[n]) {
                isBipartiteGraph = false
                return
            }
        }
    }
}
