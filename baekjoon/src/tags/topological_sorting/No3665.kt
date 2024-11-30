package tags.topological_sorting

/**
 * https://www.acmicpc.net/problem/3665
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var indegrees: IntArray
private lateinit var edges: Array<BooleanArray>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        indegrees = IntArray(n + 1)
        edges = edges(n)
        val m = readln().toInt()
        repeat(m) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            swap(a, b)
        }

        println(topologySort(n))
    }
}

private fun edges(n: Int): Array<BooleanArray> {
    val edges = Array(n + 1) { BooleanArray(n + 1) }
    val rankings = readln().split(" ").map { it.toInt() }.toIntArray()
    rankings.forEachIndexed { i, v ->
        indegrees[v] = i
        for (j in 1..n) {
            if (rankings[i] != j && !edges[j][v]) {
                edges[v][j] = true
            }
        }
    }
    return edges
}

private fun swap(a: Int, b: Int) {
    if (edges[a][b]) {
        edges[a][b] = false
        edges[b][a] = true
        indegrees[b]--
        indegrees[a]++
    } else {
        edges[a][b] = true
        edges[b][a] = false
        indegrees[a]--
        indegrees[b]++
    }
}

private fun topologySort(n: Int): String {
    val queue: Queue<Int> = LinkedList()
    (1..n).forEach { i ->
        if (indegrees[i] == 0) {
            queue.add(i)
        }
    }

    val orders = mutableListOf<Int>()
    repeat(n) {
        if (queue.isEmpty()) {
            return "IMPOSSIBLE"
        }
        if (queue.size > 1) {
            return "?"
        }

        val src = queue.poll()
        orders.add(src)
        (1..n).forEach { j ->
            if (edges[src][j]) {
                edges[src][j] = false
                indegrees[j]--
                if (indegrees[j] == 0) {
                    queue.add(j)
                }
            }
        }
    }
    return orders.joinToString(" ")
}
