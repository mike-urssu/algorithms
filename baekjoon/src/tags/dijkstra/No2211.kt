package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/2211
 */
import java.util.PriorityQueue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    val parents = getParents(n)

    println(n - 1)
    (2..n).forEach { i -> println("$i ${parents[i]}") }
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

private fun getParents(n: Int): IntArray {
    val times = IntArray(n + 1) { Int.MAX_VALUE }
    val parents = IntArray(n + 1) { it }
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }

    times[1] = 0
    queue.add(Pair(1, 0))

    while (queue.isNotEmpty()) {
        val (i, t1) = queue.poll()
        if (times[i] < t1) {
            continue
        }

        for ((j, t2) in graph[i]) {
            if (times[j] > t1 + t2) {
                times[j] = t1 + t2
                parents[j] = i
                queue.add(Pair(j, t1 + t2))
            }
        }
    }

    return parents
}
