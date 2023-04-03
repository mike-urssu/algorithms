package tags.dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.SortedSet

/**
 * https://www.acmicpc.net/problem/24479
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var graph: MutableList<SortedSet<Int>>
private lateinit var isVisited: IntArray
private var order = 1

fun main() {
    val (n, m, r) = reader.readLine().split(" ").map { it.toInt() }
    isVisited = IntArray(n + 1)
    graph = mutableListOf()
    repeat(n + 1) { graph.add(sortedSetOf()) }
    repeat(m) {
        val (src, dest) = reader.readLine().split(" ").map { it.toInt() }
        graph[src].add(dest)
        graph[dest].add(src)
    }

    dfs(r)

    for (i in 1 until isVisited.size) {
        writer.write("${isVisited[i]}\n")
    }
    writer.flush()
}

private fun dfs(index: Int) {
    isVisited[index] = order++

    for (n in graph[index]) {
        if (isVisited[n] == 0) {
            dfs(n)
        }
    }
}
