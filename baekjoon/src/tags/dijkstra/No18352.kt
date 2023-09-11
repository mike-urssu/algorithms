package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/18352
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>

fun main() {
    val (n, m, k, x) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    val cities = getCities(n, x, k)
    if (cities.isEmpty()) {
        println(-1)
    } else {
        cities.sorted().forEach { println(it) }
    }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
    }
    return graph
}

private fun getCities(n: Int, x: Int, k: Int): List<Int> {
    val cities = mutableListOf<Int>()
    val isVisited = BooleanArray(n + 1)
    val distances = IntArray(n + 1)
    val queue: Queue<Pair<Int, Int>> = PriorityQueue { it, other ->
        it.second.compareTo(other.second)
    }

    distances[x] = 0
    isVisited[x] = true
    queue.add(Pair(x, 0))
    while (queue.isNotEmpty()) {
        val (i, d1) = queue.poll()
        if (d1 == k) {
            cities.add(i)
            continue
        }

        for (j in graph[i]) {
            if (!isVisited[j]) {
                isVisited[j] = true
                queue.add(Pair(j, d1 + 1))
            }
        }
    }

    return cities
}
