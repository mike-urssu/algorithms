package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1504
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, e) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, e)
    val (v1, v2) = readln().split(" ").map { it.toInt() }

    val d1 = getDistances(n, 1)
    val d2 = getDistances(n, v1)
    val d3 = getDistances(n, v2)

    val min = (d1[v1] + d2[v2] + d3[n]).coerceAtMost(d1[v2] + d3[v1] + d2[n])
    if (min >= 600000000) {
        println(-1)
    } else {
        println(min)
    }
}

private fun getGraph(n: Int, e: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }
    return graph
}

private fun getDistances(n: Int, src: Int): IntArray {
    val distances = IntArray(n + 1) { 600000000 }
    val queue: Queue<Pair<Int, Int>> = PriorityQueue { it, other ->
        it.second.compareTo(other.second)
    }

    distances[src] = 0
    queue.add(Pair(src, 0))

    while (queue.isNotEmpty()) {
        val (i, d1) = queue.poll()
        if (distances[i] < d1) {
            continue
        }

        for ((j, d2) in graph[i]) {
            if (distances[j] > d1 + d2) {
                distances[j] = d1 + d2
                queue.add(Pair(j, d1 + d2))
            }
        }
    }

    return distances
}
