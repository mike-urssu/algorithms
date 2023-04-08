package tags.dfs

import java.util.LinkedList
import java.util.Queue

/**
 * https://www.acmicpc.net/problem/1260
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: BooleanArray

fun main() {
    val (n, m, v) = readln().split(" ").map { it.toInt() }
    graph = Array(n + 1) { IntArray(n + 1) }
    repeat(m) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        graph[from][to] = 1
        graph[to][from] = 1
    }

    isVisited = BooleanArray(n + 1)
    dfs(v)
    println()
    isVisited = BooleanArray(n + 1)
    bfs(v)
}

private fun dfs(start: Int) {
    isVisited[start] = true
    print("$start ")

    for (i in 1 until isVisited.size) {
        if (!isVisited[i] && graph[start][i] == 1) {
            dfs(i)
        }
    }
}

private fun bfs(start: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    isVisited[start] = true

    while (queue.isNotEmpty()) {
        val index = queue.poll()
        print("$index ")
        for (i in graph.indices) {
            if (!isVisited[i] && graph[index][i] == 1) {
                queue.add(i)
                isVisited[i] = true
            }
        }
    }
}
