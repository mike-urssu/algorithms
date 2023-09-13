package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/9370
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        val (n, m, t) = readln().split(" ").map { it.toInt() }
        val (s, g, h) = readln().split(" ").map { it.toInt() }
        graph = getGraph(n, m)
        val destinations = IntArray(t) { readln().toInt() }

        val candidates = getCandidates(n, s, g, h, destinations)
        println(candidates.sorted().joinToString(" "))
    }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, d) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, d))
        graph[b].add(Pair(a, d))
    }
    return graph
}

private fun getCandidates(n: Int, s: Int, g: Int, h: Int, destinations: IntArray): List<Int> {
    val distancesS = getDistances(n, s)
    val distancesG = getDistances(n, g)
    val distancesH = getDistances(n, h)

    val candidates = mutableListOf<Int>()
    for (dst in destinations) {
        val srcToDst = distancesS[dst]
        if (srcToDst == distancesS[g] + distancesG[h] + distancesH[dst] || srcToDst == distancesS[h] + distancesH[g] + distancesG[dst]) {
            candidates.add(dst)
        }
    }
    return candidates
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
