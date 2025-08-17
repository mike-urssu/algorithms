package tags.bfs

/**
 * https://www.acmicpc.net/problem/15591
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n)
    val usado = Array(n + 1) { bfs(n, it) }
    repeat(q) {
        val (k, v) = readln().split(" ").map { it.toInt() }
        println(usado[v].count { it != 2_000_000_000 && it >= k })
    }
}

private fun getGraph(n: Int): Array<MutableList<Pair<Int, Int>>> {
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n - 1) {
        val (p, q, r) = readln().split(" ").map { it.toInt() }
        graph[p].add(q to r)
        graph[q].add(p to r)
    }
    return graph
}

private fun bfs(n: Int, root: Int): IntArray {
    val usado = IntArray(n + 1) { 2_000_000_000 }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val isVisited = BooleanArray(n + 1)
    queue.add(root to 2_000_000_000)
    isVisited[root] = true

    while (queue.isNotEmpty()) {
        val (src, r1) = queue.poll()
        graph[src].forEach { (dst, r2) ->
            if (!isVisited[dst]) {
                isVisited[dst] = true
                usado[dst] = minOf(r1, r2)
                queue.add(dst to usado[dst])
            }
        }
    }
    return usado
}
