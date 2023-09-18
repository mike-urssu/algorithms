package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/5719
 */
import java.util.PriorityQueue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private lateinit var isErased: Array<BooleanArray>
private lateinit var paths: Array<MutableList<Int>>

fun main() {
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }

        val (s, d) = readln().split(" ").map { it.toInt() }
        graph = getGraph(n, m)
        isErased = Array(n) { BooleanArray(n) }

        paths = getPaths(n, s)
        removeNodes(d)

        val distances = getDistances(n, s)
        if (distances[d] == Int.MAX_VALUE) {
            println(-1)
        } else {
            println(distances[d])
        }
    }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (u, v, p) = readln().split(" ").map { it.toInt() }
        graph[u].add(Pair(v, p))
    }
    return graph
}

private fun getPaths(n: Int, s: Int): Array<MutableList<Int>> {
    val paths = Array(n) { mutableListOf<Int>() }
    val distances = IntArray(n) { Int.MAX_VALUE }
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }

    distances[s] = 0
    queue.add(Pair(s, 0))

    while (queue.isNotEmpty()) {
        val (i, d1) = queue.poll()
        if (distances[i] < d1) {
            continue
        }

        for ((j, d2) in graph[i]) {
            if (distances[j] > d1 + d2) {
                distances[j] = d1 + d2
                paths[j] = mutableListOf(i)
                queue.add(Pair(j, distances[j]))
            } else if (distances[j] == d1 + d2) {
                paths[j].add(i)
            }
        }
    }

    return paths
}

private fun removeNodes(d: Int) {
    for (node in paths[d]) {
        if (!isErased[node][d]) {
            isErased[node][d] = true
            removeNodes(node)
        }
    }
}

private fun getDistances(n: Int, s: Int): IntArray {
    val distances = IntArray(n) { Int.MAX_VALUE }
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }

    distances[s] = 0
    queue.add(Pair(s, 0))

    while (queue.isNotEmpty()) {
        val (i, d1) = queue.poll()
        if (distances[i] < d1) {
            continue
        }

        for ((j, d2) in graph[i]) {
            if (!isErased[i][j]) {
                if (distances[j] > d1 + d2) {
                    distances[j] = d1 + d2
                    queue.add(Pair(j, distances[j]))
                }
            }
        }
    }

    return distances
}
