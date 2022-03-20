package dfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var graph: Array<ArrayList<Int>>
private lateinit var counts: IntArray
private lateinit var isVisited: BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var tokenizer = StringTokenizer(readLine())
    val computers = tokenizer.nextToken().toInt()
    graph = Array(computers + 1) { ArrayList() }

    val numberOfInput = tokenizer.nextToken().toInt()
    repeat(numberOfInput) {
        tokenizer = StringTokenizer(readLine())
        val target = tokenizer.nextToken().toInt()
        val source = tokenizer.nextToken().toInt()
        graph[source].add(target)
    }

    counts = IntArray(computers + 1)
    var maxCount = 0
    for (i in 1..computers) {
        isVisited = BooleanArray(computers + 1)
        dfs(i, i)
        maxCount = maxCount.coerceAtLeast(counts[i])
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        for (i in counts.indices) {
            if (maxCount == counts[i])
                write("$i ")
        }
        flush()
    }
}

private fun dfs(source: Int, index: Int) {
    isVisited[index] = true

    for (i in graph[index]) {
        if (!isVisited[i]) {
            dfs(source, i)
            counts[source]++
        }
    }
}
