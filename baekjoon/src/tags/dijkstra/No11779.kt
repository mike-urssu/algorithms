package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/11779
 */
import java.util.PriorityQueue
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>
private lateinit var distances: IntArray
private lateinit var paths: IntArray

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    graph = getGraph(n, m)

    val (src, dst) = readln().split(" ").map { it.toInt() }
    setDistancesAndPaths(n, src)
    val cities = getCities(src, dst)

    println(distances[dst])
    println(cities.size)
    println(cities.reversed().joinToString(" "))
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (src, dst, distance) = readln().split(" ").map { it.toInt() }
        graph[src].add(Pair(dst, distance))
    }
    return graph
}

private fun setDistancesAndPaths(n: Int, src: Int) {
    distances = IntArray(n + 1) { Int.MAX_VALUE }
    paths = IntArray(n + 1)
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
                paths[j] = i
                distances[j] = d1 + d2
                queue.add(Pair(j, distances[j]))
            }
        }
    }
}

private fun getCities(src: Int, dst: Int): List<Int> {
    val cities = mutableListOf<Int>()
    var city = dst
    while (paths[city] != 0) {
        cities.add(city)
        city = paths[city]
    }
    cities.add(src)
    return cities
}
