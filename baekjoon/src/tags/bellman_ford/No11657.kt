package tags.bellman_ford

/**
 * https://www.acmicpc.net/problem/11657
 */
private lateinit var graph: List<Triple<Int, Int, Int>>
private lateinit var times: LongArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(m)
    times = getTimes(n, graph)

    if (containsCycle(graph)) {
        println(-1)
    } else {
        (2..n).forEach { i ->
            if (times[i] == Long.MAX_VALUE) {
                println(-1)
            } else {
                println(times[i])
            }
        }
    }
}

private fun getGraph(m: Int): List<Triple<Int, Int, Int>> {
    val graph = mutableListOf<Triple<Int, Int, Int>>()
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph.add(Triple(a, b, c))
    }
    return graph
}

private fun getTimes(n: Int, graph: List<Triple<Int, Int, Int>>): LongArray {
    val times = LongArray(n + 1) { Long.MAX_VALUE }
    times[1] = 0
    repeat(n - 1) {
        graph.forEach { (src, dst, time) ->
            if (times[src] != Long.MAX_VALUE && times[dst] > times[src] + time) {
                times[dst] = times[src] + time
            }
        }
    }
    return times
}

private fun containsCycle(graph: List<Triple<Int, Int, Int>>) =
    graph.any { (src, dst, time) ->
        times[src] != Long.MAX_VALUE && times[dst] > times[src] + time
    }
