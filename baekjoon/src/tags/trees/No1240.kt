package tags.trees

/**
 * https://www.acmicpc.net/problem/1240
 */
import java.util.PriorityQueue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n)

    repeat(m) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        println(getDistance(n, src, dst))
    }
}

private fun getGraph(n: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n - 1) {
        val (src, dst, distance) = readln().split(" ").map { it.toInt() }
        graph[src].add(dst to distance)
        graph[dst].add(src to distance)
    }
    return graph
}

private fun getDistance(n: Int, src: Int, dst: Int): Int {
    val isVisited = BooleanArray(n + 1)
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }
    isVisited[src] = true
    queue.add(src to 0)

    var distance = 0
    while (queue.isNotEmpty()) {
        val (node, d1) = queue.poll()
        if (node == dst) {
            distance = d1
            break
        }

        graph[node].forEach { (i, d2) ->
            if (!isVisited[i]) {
                isVisited[i] = true
                queue.add(i to d1 + d2)
            }
        }
    }

    return distance
}
