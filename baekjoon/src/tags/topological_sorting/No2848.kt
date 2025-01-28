package tags.topological_sorting

/**
 * https://www.acmicpc.net/problem/2848
 */
import java.util.LinkedList
import java.util.Queue
import kotlin.system.exitProcess

private lateinit var isVisited: BooleanArray
private lateinit var graph: Array<MutableList<Int>>
private val indegree = IntArray(26)

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

private fun graph(n: Int, words: Array<IntArray>): Array<MutableList<Int>> {
    val graph = Array(26) { mutableListOf<Int>() }
    for (i in 0 until n - 1) {
        for (j in words[i].indices) {
            if (j >= words[i + 1].size) {
                println("!")
                exitProcess(0)
            }

            if (words[i][j] != words[i + 1][j]) {
                graph[words[i][j]].add(words[i + 1][j])
                indegree[words[i + 1][j]]++
                break
            }
        }
    }
    return graph
}

private fun topologySort(): String {
    val queue: Queue<Int> = LinkedList()
    val visitedLetters = (0 until 26).filter { isVisited[it] }
    queue.addAll(visitedLetters.filter { indegree[it] == 0 })

    var isVarious = false
    val order = StringBuilder()
    repeat(visitedLetters.size) {
        if (queue.isEmpty()) {
            return "!"
        } else if (queue.size >= 2) {
            isVarious = true
        }

        val p = queue.poll()
        order.append('a' + p)
        graph[p].forEach {
            if (--indegree[it] == 0) {
                queue.add(it)
            }
        }
    }

    return if (isVarious) {
        "?"
    } else {
        order.toString()
    }
}
