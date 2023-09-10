package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/1753
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, e) = reader.readLine().split(" ").map { it.toInt() }
    val k = reader.readLine().toInt()

    graph = getGraph(n, e)

    val distances = getDistances(n, k)
    for (i in 1..n) {
        if (distances[i] != Int.MAX_VALUE) {
            println(distances[i])
        } else {
            println("INF")
        }
    }
}

private fun getGraph(n: Int, e: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(e) {
        val (u, v, w) = reader.readLine().split(" ").map { it.toInt() }
        graph[u].add(Pair(v, w))
    }
    return graph
}

private fun getDistances(n: Int, k: Int): IntArray {
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    val isVisited = BooleanArray(n + 1)

    distances[k] = 0
    graph[k].forEach { (v, w) -> distances[v] = distances[v].coerceAtMost(w) }
    isVisited[0] = true
    isVisited[k] = true

    repeat(n - 1) {
        val i = getIndex(distances, isVisited)
        graph[i].forEach { (v, w) ->
            if (!isVisited[v]) {
                distances[v] = distances[v].coerceAtMost(distances[i] + w)
            }
        }
        isVisited[i] = true
    }

    return distances
}

private fun getIndex(distances: IntArray, isVisited: BooleanArray): Int {
    var index = 0
    var min = Int.MAX_VALUE
    for (i in distances.indices) {
        if (!isVisited[i] && distances[i] < min) {
            index = i
            min = distances[i]
        }
    }
    return index
}
