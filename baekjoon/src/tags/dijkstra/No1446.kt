package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1446
 */
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, d) = readln().split(" ").map { it.toInt() }
    graph = getGraph(d, n)
    val distances = getDistances(d)
    println(distances.last())
}

private fun getGraph(d: Int, n: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(d + 1) { mutableListOf<Pair<Int, Int>>() }
    for (i in 0 until n) {
        val (src, dst, length) = readln().split(" ").map { it.toInt() }
        if (dst > d || length > dst - src) {
            continue
        }
        graph[dst].add(Pair(src, length))
    }
    return graph
}

private fun getDistances(d: Int): IntArray {
    val distances = IntArray(d + 1) { it }
    for (i in 1..d) {
        if (graph[i].isEmpty()) {
            distances[i] = distances[i - 1] + 1
        } else {
            for ((j, d2) in graph[i]) {
                distances[i] = minOf(distances[i - 1] + 1, distances[i], distances[j] + d2)
            }
        }
    }
    return distances
}
