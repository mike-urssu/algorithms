package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17471
 */
import java.util.LinkedList
import java.util.Queue
import kotlin.math.absoluteValue

private lateinit var populations: IntArray
private lateinit var graph: Array<MutableList<Int>>

private lateinit var sections: IntArray
private lateinit var isVisited: BooleanArray

private var min = Int.MAX_VALUE

fun main() {
    val n = readln().toInt()
    populations = getPopulations(n)
    graph = getGraph(n)

    (1..n / 2).forEach { i ->
        sections = IntArray(i)
        isVisited = BooleanArray(n + 1)
        divideSections(n, i, 0, 1)
    }

    if (min == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(min)
    }
}

private fun getPopulations(n: Int): IntArray {
    val populations = IntArray(n + 1)
    readln().split(" ").map { it.toInt() }.toIntArray()
        .copyInto(populations, 1)
    return populations
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    (1..n).forEach { i ->
        val connectedNodes = readln().split(" ").map { it.toInt() }.drop(1)
        graph[i].addAll(connectedNodes)
    }
    return graph
}

private fun divideSections(n: Int, r: Int, index: Int, from: Int) {
    if (r == index) {
        val otherSections = (1..n).filterNot { it in sections }.toIntArray()
        if (isConnected(n, r, sections) && isConnected(n, n - r, otherSections)) {
            val diff = (sections.sumOf { populations[it] } - otherSections.sumOf { populations[it] }).absoluteValue
            min = min.coerceAtMost(diff)
        }
        return
    }

    for (i in from..n) {
        if (!isVisited[i]) {
            isVisited[i] = true
            sections[index] = i
            divideSections(n, r, index + 1, i + 1)
            isVisited[i] = false
        }
    }
}

private fun isConnected(n: Int, r: Int, sections: IntArray): Boolean {
    val queue: Queue<Int> = LinkedList<Int>().apply { this.add(sections[0]) }
    val isVisited = BooleanArray(n + 1).apply { this[sections[0]] = true }
    var count = 1

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        for (connectedNode in graph[node]) {
            if (sections.contains(connectedNode) && !isVisited[connectedNode]) {
                queue.add(connectedNode)
                isVisited[connectedNode] = true
                count++
            }
        }
    }

    return r == count
}
