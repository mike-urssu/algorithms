package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/14284
 */
import java.util.PriorityQueue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = getGraph(n, m)
    val (s, t) = readln().split(" ").map { it.toInt() }

    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }
    queue.add(s to 0)
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    while (queue.isNotEmpty()) {
        val (dst, cost) = queue.poll()
        graph[dst].forEach { (node, c) ->
            if (distances[node] > cost + c) {
                distances[node] = cost + c
                queue.add(node to cost + c)
            }
        }
    }
    println(distances[t])
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(b to c)
        graph[b].add(a to c)
    }
    return graph
}
