package tags.bfs

/**
 * https://www.acmicpc.net/problem/17471
 */
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

private lateinit var graph: Array<MutableList<Int>>
private lateinit var populations: IntArray
private var gap = Int.MAX_VALUE

fun main() {
    val n = readln().toInt()
    populations = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    graph = getGraph(n)

    setGap(n)
    if (gap == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(gap)
    }
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n) { i ->
        val sections = readln().split(" ").map { it.toInt() }.drop(1)
        graph[i + 1].addAll(sections)
    }
    return graph
}

private fun setGap(n: Int) {
    for (i in 1..n / 2) {
        val sections = IntArray(i)
        for (j in 1..n) {
            combination(sections, n, i, 0, j)
        }
    }
}

private fun combination(sections: IntArray, n: Int, r: Int, index: Int, value: Int) {
    sections[index] = value
    if (index == r - 1) {
        val otherSections = getOtherSections(n, sections)
        if (isConnected(n, sections) && isConnected(n, otherSections)) {
            gap = gap.coerceAtMost(abs(sections.sumOf { populations[it] } - otherSections.sumOf { populations[it] }))
        }
        return
    }

    for (i in value + 1..n) {
        combination(sections, n, r, index + 1, i)
    }
}

private fun getOtherSections(n: Int, sections: IntArray) =
    (1..n).filter { it !in sections }.toIntArray()

private fun isConnected(n: Int, sections: IntArray): Boolean {
    val isVisited = BooleanArray(n + 1)
    val queue: Queue<Int> = LinkedList()

    isVisited[sections.first()] = true
    queue.add(sections.first())

    while (queue.isNotEmpty()) {
        val i = queue.poll()
        graph[i].forEach {
            if (sections.contains(it) && !isVisited[it]) {
                isVisited[it] = true
                queue.add(it)
            }
        }
    }

    return sections.all { isVisited[it] }
}
