package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/10282
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, d, c) = readln().split(" ").map { it.toInt() }
        graph = getGraph(n, d)
        println(getInfections(n, c).joinToString(" "))
    }
}

private fun getGraph(n: Int, d: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(d) {
        val (a, b, s) = readln().split(" ").map { it.toInt() }
        graph[b].add(Pair(a, s))
    }
    return graph
}

private fun getInfections(n: Int, c: Int): IntArray {
    val seconds = IntArray(n + 1) { Int.MAX_VALUE }
    val queue: Queue<Pair<Int, Int>> = PriorityQueue { it, other ->
        it.second.compareTo(other.second)
    }

    seconds[c] = 0
    queue.add(Pair(c, 0))

    while (queue.isNotEmpty()) {
        val (i, s1) = queue.poll()
        if (seconds[i] < s1) {
            continue
        }

        for ((j, s2) in graph[i]) {
            if (seconds[j] > s1 + s2) {
                seconds[j] = s1 + s2
                queue.add(Pair(j, seconds[j]))
            }
        }
    }

    val count = seconds.count { it != Int.MAX_VALUE }
    val second = seconds.filter { it != Int.MAX_VALUE }.max()
    return intArrayOf(count, second)
}
