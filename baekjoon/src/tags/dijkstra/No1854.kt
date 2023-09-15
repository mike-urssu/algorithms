package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1854
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)
    val distances = getDistances(n, k)

    for (i in 1..n) {
        if (distances[i].size < k) {
            println(-1)
        } else {
            println(distances[i].peek())
        }
    }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
    }
    return graph
}

private fun getDistances(n: Int, k: Int): Array<PriorityQueue<Int>> {
    val distances = Array(n + 1) { PriorityQueue<Int>(Comparator.reverseOrder()) }
    val queue: Queue<Pair<Int, Int>> = PriorityQueue { it, other ->
        it.second.compareTo(other.second)
    }

    distances[1].add(0)
    queue.add(Pair(1, 0))

    while (queue.isNotEmpty()) {
        val (i, d1) = queue.poll()
        for ((j, d2) in graph[i]) {
            if (distances[j].size < k) {
                distances[j].add(d1 + d2)
                queue.add(Pair(j, d1 + d2))
            } else {
                if (distances[j].peek() > d1 + d2) {
                    distances[j].poll()
                    distances[j].add(d1 + d2)
                    queue.add(Pair(j, d1 + d2))
                }
            }
        }
    }

    return distances
}
