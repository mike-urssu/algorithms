package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/11725
 */
private lateinit var graph: Array<ArrayList<Int>>
private lateinit var parentNodes: IntArray
private lateinit var isVisited: BooleanArray
private var size = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    size = readLine().toInt()

    graph = Array(size + 1) { arrayListOf() }
    parentNodes = IntArray(size + 1)
    isVisited = BooleanArray(size + 1)

    repeat(size - 1) {
        val tokenizer = StringTokenizer(readLine())
        val num1 = tokenizer.nextToken().toInt()
        val num2 = tokenizer.nextToken().toInt()
        graph[num1].add(num2)
        graph[num2].add(num1)
    }

    for (i in 1..size) {
        if (!isVisited[i])
            dfs(i)
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        for (i in 2..size) {
            write("${parentNodes[i]}")
            newLine()
        }
        flush()
    }
}

private fun dfs(index: Int) {
    isVisited[index] = true
    for (number in graph[index]) {
        if (!isVisited[number]) {
            parentNodes[number] = index
            dfs(number)
        }
    }
}