package tags.mst

/**
 * https://www.acmicpc.net/problem/16398
 */
import java.util.PriorityQueue

private lateinit var graph: Array<IntArray>
private lateinit var parents: IntArray

fun main() {
    val n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    parents = IntArray(n) { it }

    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }
    (0 until n).forEach { i ->
        (i + 1 until n).forEach { j ->
            queue.add(Triple(i, j, graph[i][j]))
        }
    }

    var cost = 0L
    while (queue.isNotEmpty()) {
        val (i, j, c) = queue.poll()
        if (find(i) != find(j)) {
            union(i, j)
            cost += c
        }
    }
    println(cost)
}

private fun union(n: Int, m: Int) {
    val parentN = find(n)
    val parentM = find(m)
    parents[parentN] = parentM
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
