package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1753
 */
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

private val reader = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, e) = reader.readLine().split(" ").map { it.toInt() }
    val k = reader.readLine().toInt()

    graph = getGraph(n, e)

    val distances = getDistances(n, k)
    for (i in 1..n) {
        if (distances[i] != Int.MAX_VALUE) {
            println(distances[i])
        } else {
            println("INF")
        }
    }
}

private fun getGraph(n: Int, e: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(e) {
        val (u, v, w) = reader.readLine().split(" ").map { it.toInt() }
        graph[u].add(Pair(v, w))
    }
    return graph
}

private fun getDistances(n: Int, k: Int): IntArray {
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    val queue = PriorityQueue<Pair<Int, Int>> { it, other ->
        it.second.compareTo(other.second)
    }

    distances[k] = 0
    queue.add(Pair(k, 0))
    while (queue.isNotEmpty()) {
        val (v, w) = queue.poll()
        if (distances[v] < w) {
            continue
        }

        for ((v2, w2) in graph[v]) {
            if (distances[v2] > w + w2) {
                distances[v2] = w + w2
                queue.add(Pair(v2, distances[v2]))
            }
        }
    }

    return distances
}
