package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1916
 */
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.Queue

private val reader = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val n = reader.readLine().toInt()
    val m = reader.readLine().toInt()
    graph = getGraph(n, m)
    val (src, dst) = reader.readLine().split(" ").map { it.toInt() }

    val distances = getDistances(n, src)
    println(distances[dst])
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (src, dst, distance) = reader.readLine().split(" ").map { it.toInt() }
        graph[src].add(Pair(dst, distance))
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
        val (dst, distance) = queue.poll()
        if (distances[dst] < distance) {
            continue
        }

        for ((dst2, distance2) in graph[dst]) {
            if (distances[dst2] > distance + distance2) {
                distances[dst2] = distance + distance2
                queue.add(Pair(dst2, distance + distance2))
            }
        }
    }

    return distances
}
