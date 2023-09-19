package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1719
 */
import java.util.PriorityQueue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    val routeChart = getRouteChart(n)
    printRouteChart(n, routeChart)
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

private fun getRouteChart(n: Int): Array<IntArray> {
    val routeChart = Array(n + 1) { IntArray(n) }
    (1..n).forEach { i ->
        routeChart[i] = getRoute(n, i)
    }
    return routeChart
}

private fun getRoute(n: Int, src: Int): IntArray {
    val parents = getParents(n, src)
    val route = IntArray(n + 1)
    for (i in 1..n) {
        route[i] = getParent(parents, src, i)
    }
    return route
}

private fun getParents(n: Int, s: Int): IntArray {
    val parents = IntArray(n + 1) { it }
    val times = IntArray(n + 1) { Int.MAX_VALUE }
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }

    times[s] = 0
    queue.add(Pair(s, 0))

    while (queue.isNotEmpty()) {
        val (i, t1) = queue.poll()
        if (times[i] < t1) {
            continue
        }

        for ((j, t2) in graph[i]) {
            if (times[j] > t1 + t2) {
                parents[j] = i
                times[j] = t1 + t2
                queue.add(Pair(j, times[j]))
            }
        }
    }

    return parents
}

private fun getParent(parents: IntArray, src: Int, index: Int): Int {
    return if (parents[index] == src) {
        index
    } else {
        getParent(parents, src, parents[index])
    }
}

private fun printRouteChart(n: Int, routeChart: Array<IntArray>) {
    (1..n).forEach { i ->
        (1..n).forEach { j ->
            if (i == j) {
                print("- ")
            } else {
                print("${routeChart[i][j]} ")
            }
        }
        println()
    }
}
