package tags.topological_sorting

/**
 * https://www.acmicpc.net/problem/2848
 */
import java.util.LinkedList
import java.util.Queue
import kotlin.system.exitProcess

private lateinit var isVisited: BooleanArray
private lateinit var graph: Array<BooleanArray>
private val indegrees = IntArray(26)

fun main() {
    val n = readln().toInt()
    val words = Array(n) { readln().map { it - 'a' }.toIntArray() }
    isVisited = isVisited(words)
    graph = graph(n, words)
    println(topologySort())
}

private fun isVisited(words: Array<IntArray>): BooleanArray {
    val isVisited = BooleanArray(26)
    words.forEach { word -> word.forEach { isVisited[it] = true } }
    return isVisited
}

private fun graph(n: Int, words: Array<IntArray>): Array<BooleanArray> {
    val graph = Array(26) { BooleanArray(26) }
    for (i in 0 until n - 1) {
        for (j in words[i].indices) {
            if (j < words[i + 1].size) {
                if (words[i][j] != words[i + 1][j]) {
                    if (graph[words[i][j]][words[i + 1][j]]) {
                        break
                    }

                    if (graph[words[i + 1][j]][words[i][j]]) {
                        println("!")
                        exitProcess(0)
                    }

                    graph[words[i][j]][words[i + 1][j]] = true
                    indegrees[words[i + 1][j]]++
                    break
                }
            } else {
                println("!")
                exitProcess(0)
            }
        }
    }
    return graph
}

private fun topologySort(): String {
    val queue: Queue<Int> = LinkedList<Int>().apply {
        (0 until 26).forEach { i ->
            if (isVisited[i] && indegrees[i] == 0) {
                this.add(i)
            }
        }
    }

    val order = StringBuilder()
    while (queue.isNotEmpty()) {
        if (queue.size > 1) {
            return "?"
        }

        val i = queue.poll()
        order.append('a' + i)
        (0 until 26).forEach { j ->
            if (graph[i][j]) {
                graph[i][j] = false
                indegrees[j]--
                if (indegrees[j] == 0) {
                    queue.add(j)
                }
            }
        }
    }
    if (indegrees.any { it > 0 }) {
        return "!"
    }

    return order.toString()
}
