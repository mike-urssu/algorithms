package tags.dfs

/**
 * https://www.acmicpc.net/problem/16947
 */
import java.util.PriorityQueue

private lateinit var graph: Array<MutableList<Int>>
private lateinit var circles: BooleanArray
private lateinit var isVisited: BooleanArray

fun main() {
    val n = readln().toInt()
    graph = getGraph(n)
    circles = BooleanArray(n + 1).apply {
        (1..n).forEach { i ->
            isVisited = BooleanArray(n + 1)
            dfs(i, i, 0)
        }
    }
    println((1..n).map { getDistance(n, it) }.joinToString(" "))
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        graph[src].add(dst)
        graph[dst].add(src)
    }
    return graph
}

private fun dfs(src: Int, node: Int, depth: Int) {
    isVisited[node] = true

    graph[node].forEach { dst ->
        if (src == dst && depth > 1) {
            circles[src] = true
            return
        }

        if (!isVisited[dst]) {
            dfs(src, dst, depth + 1)
        }
    }
}

private fun getDistance(n: Int, src: Int): Int {
    val isVisited = BooleanArray(n + 1)
    val queue = PriorityQueue<Pair<Int, Int>> { it, other -> it.second.compareTo(other.second) }

    isVisited[src] = true
    queue.add(Pair(src, 0))

    var distance = Int.MAX_VALUE
    while (queue.isNotEmpty()) {
        val (node, d) = queue.poll()
        if (circles[node]) {
            distance = d
            break
        }

        graph[node].forEach { dst ->
            if (!isVisited[dst]) {
                isVisited[dst] = true
                queue.add(Pair(dst, d + 1))
            }
        }
    }

    return distance
}
