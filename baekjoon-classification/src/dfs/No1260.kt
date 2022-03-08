package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/1260
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var tokenizer = StringTokenizer(reader.readLine())
    val edges = tokenizer.nextToken().toInt()
    val nodes = tokenizer.nextToken().toInt()
    val startIndex = tokenizer.nextToken().toInt()

    val graph = Array(edges + 1) { IntArray(edges + 1) }
    repeat(nodes) {
        tokenizer = StringTokenizer(reader.readLine())
        val row = tokenizer.nextToken().toInt()
        val col = tokenizer.nextToken().toInt()
        graph[row][col] = 1
        graph[col][row] = 1
    }

    var isVisited = BooleanArray(edges + 1)
    dfs(graph, isVisited, startIndex)
    writer.newLine()

    val queue = LinkedList<Int>()
    isVisited = BooleanArray(edges + 1)
    bfs(queue, graph, isVisited, startIndex)
    writer.flush()
}

private fun dfs(graph: Array<IntArray>, isVisited: BooleanArray, index: Int) {
    isVisited[index] = true
    writer.write("$index ")

    for (i in 1 until isVisited.size) {
        if (!isVisited[i] && graph[index][i] == 1)
            dfs(graph, isVisited, i)
    }
}

private fun bfs(queue: Queue<Int>, graph: Array<IntArray>, isVisited: BooleanArray, index: Int) {
    isVisited[index] = true
    queue.add(index)

    while (queue.isNotEmpty()) {
        val newIndex = queue.poll()
        writer.write("$newIndex ")

        for (i in 1 until isVisited.size) {
            if (!isVisited[i] && graph[newIndex][i] == 1) {
                isVisited[i] = true
                queue.add(i)
            }
        }
    }
}