package tags.dfs

/**
 * https://www.acmicpc.net/problem/1325
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var graph: Array<MutableList<Int>>
private lateinit var isVisited: IntArray
private lateinit var counts: IntArray

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { mutableListOf() }
    counts = IntArray(n + 1)

    repeat(m) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
    }

    for (i in 1..n) {
        isVisited = IntArray(n + 1)
        isVisited[i] = 1
        dfs(i)
    }

    val max = counts.max()
    for (i in counts.indices) {
        if (counts[i] == max) {
            print("$i ")
        }
    }
    writer.flush()
}

private fun dfs(index: Int) {
    for (n in graph[index]) {
        if (isVisited[n] == 0) {
            counts[n]++
            isVisited[n] = 1
            dfs(n)
        }
    }
}
