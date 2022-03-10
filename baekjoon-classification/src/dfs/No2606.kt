package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/2606
 */
private var count = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nodes = readLine().toInt()
    val edges = readLine().toInt()
    val graph = Array(nodes + 1) { IntArray(nodes + 1) }
    val isVisited = BooleanArray(nodes + 1)

    var tokenizer: StringTokenizer
    repeat(edges) {
        tokenizer = StringTokenizer(readLine())
        val row = tokenizer.nextToken().toInt()
        val col = tokenizer.nextToken().toInt()
        graph[row][col] = 1
        graph[col][row] = 1
    }

    dfs(graph, isVisited, 1)

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${count - 1}")
        flush()
    }
}

private fun dfs(graph: Array<IntArray>, isVisited: BooleanArray, index: Int) {
    isVisited[index] = true
    count++

    for (i in 1 until graph.size) {
        if (!isVisited[i] && graph[index][i] == 1)
            dfs(graph, isVisited, i)
    }
}