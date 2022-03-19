package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/2644
 */
private lateinit var graph: ArrayList<ArrayList<Int>>
private lateinit var isVisited: BooleanArray
private var count = -1

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val people = readLine().toInt()
    graph = arrayListOf()
    repeat(people + 1) { graph.add(arrayListOf()) }
    isVisited = BooleanArray(people + 1)

    var tokenizer = StringTokenizer(readLine())
    val source = tokenizer.nextToken().toInt()
    val target = tokenizer.nextToken().toInt()

    val numberOfInput = readLine().toInt()
    repeat(numberOfInput) {
        tokenizer = StringTokenizer(readLine())
        val parent = tokenizer.nextToken().toInt()
        val child = tokenizer.nextToken().toInt()
        graph[parent].add(child)
        graph[child].add(parent)
    }

    dfs(source, target, 0)

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("$count")
        flush()
    }
}

private fun dfs(source: Int, target: Int, depth: Int) {
    if (source == target) {
        count = depth
        return
    }

    isVisited[source] = true
    for (number in graph[source]) {
        if (!isVisited[number])
            dfs(number, target, depth + 1)
    }
}