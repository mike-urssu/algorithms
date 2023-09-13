package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/14938
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    val ts = IntArray(n + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    graph = getGraph(n, r)

    val max = (1..n).maxOf { i ->
        val distances = getDistances(n, i)
        getItems(n, m, distances, ts)
    }
    println(max)
}

private fun getGraph(n: Int, r: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(r) {
        val (a, b, l) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, l))
        graph[b].add(Pair(a, l))
    }
    return graph
}

private fun getDistances(n: Int, src: Int): IntArray {
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
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
                queue.add(Pair(j, distances[j]))
            }
        }
    }

    return distances
}

private fun getItems(n: Int, m: Int, distances: IntArray, ts: IntArray): Int {
    var items = 0
    for (i in 1..n) {
        if (distances[i] <= m) {
            items += ts[i]
        }
    }
    return items
}
