package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1162
 */
import java.util.PriorityQueue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)
    val times = getTimes(n, k)
    println(times[n].min())
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (src, dst, time) = readln().split(" ").map { it.toInt() }
        graph[src].add(Pair(dst, time))
        graph[dst].add(Pair(src, time))
    }
    return graph
}

private fun getTimes(n: Int, k: Int): Array<LongArray> {
    val times = Array(n + 1) { LongArray(k + 1) { Long.MAX_VALUE } }
    val queue = PriorityQueue<Triple<Int, Long, Int>> { it, other -> it.second.compareTo(other.second) }

    times[1][0] = 0
    queue.add(Triple(1, 0, 0))

    while (queue.isNotEmpty()) {
        val (i, t1, pavement) = queue.poll()
        if (times[i][pavement] < t1) {
            continue
        }

        for ((j, t2) in graph[i]) {
            if (times[j][pavement] > t1 + t2) {
                times[j][pavement] = t1 + t2
                queue.add(Triple(j, times[j][pavement], pavement))
            }

            if (pavement < k) {
                if (times[j][pavement + 1] > t1) {
                    times[j][pavement + 1] = t1
                    queue.add(Triple(j, times[j][pavement + 1], pavement + 1))
                }
            }
        }
    }

    return times
}
