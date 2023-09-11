package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1238
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, m, x) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    val timesToReturn = getLeastTime(n, x)
    val max = (1..n).maxOf { i ->
        val timesToGo = getLeastTime(n, i)
        timesToGo[x] + timesToReturn[i]
    }
    println(max)
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (src, dst, t) = readln().split(" ").map { it.toInt() }
        graph[src].add(Pair(dst, t))
    }
    return graph
}

private fun getLeastTime(n: Int, src: Int): IntArray {
    val times = IntArray(n + 1) { Int.MAX_VALUE }
    val queue: Queue<Pair<Int, Int>> = PriorityQueue { it, other ->
        it.second.compareTo(other.second)
    }

    times[src] = 0
    queue.add(Pair(src, 0))

    while (queue.isNotEmpty()) {
        val (i, t1) = queue.poll()
        if (times[i] < t1) {
            continue
        }

        for ((j, t2) in graph[i]) {
            if (times[j] > t1 + t2) {
                times[j] = t1 + t2
                queue.add(Pair(j, t1 + t2))
            }
        }
    }

    return times
}
