package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/17396
 */
import java.util.PriorityQueue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private lateinit var isVisible: BooleanArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    isVisible = readln().split(" ").map { it.toInt() == 1 }.toBooleanArray()
    graph = getGraph(n, m)

    val times = getTimes(n)
    if (times[n - 1] == Long.MAX_VALUE) {
        println(-1)
    } else {
        println(times[n - 1])
    }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, t) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, t))
        graph[b].add(Pair(a, t))
    }
    return graph
}

private fun getTimes(n: Int): LongArray {
    val times = LongArray(n) { Long.MAX_VALUE }
    val queue = PriorityQueue<Pair<Int, Long>> { it, other -> it.second.compareTo(other.second) }

    times[0] = 0
    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val (i, t1) = queue.poll()
        if (times[i] < t1) {
            continue
        }

        for ((j, t2) in graph[i]) {
            if ((j == n - 1 || (j != n - 1 && !isVisible[j])) && times[j] > t1 + t2) {
                times[j] = t1 + t2
                queue.add(Pair(j, times[j]))
            }
        }
    }

    return times
}
