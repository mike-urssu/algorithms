package tags.dfsAndBfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/11724
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var tokenizer = StringTokenizer(readLine())
    val nodes = tokenizer.nextToken().toInt()
    val edges = tokenizer.nextToken().toInt()

    val graph = Array(nodes + 1) { BooleanArray(nodes + 1) }
    val isVisited = BooleanArray(nodes + 1)

    repeat(edges) {
        tokenizer = StringTokenizer(readLine())
        val row = tokenizer.nextToken().toInt()
        val col = tokenizer.nextToken().toInt()
        graph[row][col] = true
        graph[col][row] = true
    }

    var count = 0
    for (i in 1 until graph.size) {
        for (j in 1 until graph.size) {
            if (!isVisited[j] && graph[i][j]) {
                dfs(graph, isVisited, j)
                count++
            }
        }
    }

    for (i in 1 until isVisited.size) {
        if (!isVisited[i])
            count++
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("$count")
        flush()
    }
}

private fun dfs(graph: Array<BooleanArray>, isVisited: BooleanArray, index: Int) {
    isVisited[index] = true
    for (i in 1 until graph.size) {
        if (!isVisited[i] && graph[index][i])
            dfs(graph, isVisited, i)
    }
}