package tags.tree

/**
 * https://www.acmicpc.net/problem/2533
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isEarlyAdaptor: BooleanArray
private lateinit var isVisited: BooleanArray

fun main() {
    val n = reader.readLine().toInt()
    graph = getGraph(n)
    isEarlyAdaptor = BooleanArray(n + 1)
    isVisited = BooleanArray(n + 1)

    dfs(1)

    println(isEarlyAdaptor.count { it })
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (u, v) = reader.readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    return graph
}

private fun dfs(src: Int) {
    isVisited[src] = true

    if (graph[src].isEmpty()) {
        isEarlyAdaptor[src] = false
        return
    }

    graph[src].forEach { node ->
        if (!isVisited[node]) {
            dfs(node)
            if (!isEarlyAdaptor[node]) {
                isEarlyAdaptor[src] = true
            }
        }
    }
}
