package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/5972
 */
import java.util.PriorityQueue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)
    println(getLeastCost(n))
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }
    return graph
}


private fun getLeastCost(n: Int): Int {
    val costs = IntArray(n + 1) { Int.MAX_VALUE }
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }

    costs[1] = 0
    queue.add(Pair(1, 0))

    while (queue.isNotEmpty()) {
        val (i, d1) = queue.poll()
        if (costs[i] < d1) {
            continue
        }

        for ((j, d2) in graph[i]) {
            if (costs[j] > d1 + d2) {
                costs[j] = d1 + d2
                queue.add(Pair(j, costs[j]))
            }
        }
    }

    return costs[n]
}
