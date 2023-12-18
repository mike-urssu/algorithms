package tags.bfs

/**
 * https://www.acmicpc.net/problem/24444
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>
private lateinit var orders: IntArray

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)
    orders = IntArray(n + 1)
    bfs(r)
    (1..n).forEach { println(orders[it]) }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    graph.forEach { it.sort() }
    return graph
}

private var order = 1

private fun bfs(src: Int) {
    val queue = LinkedList<Int>() as Queue<Int>
    orders[src] = order++
    queue.add(src)
    while (queue.isNotEmpty()) {
        val p = queue.poll()
        graph[p].forEach {
            if (orders[it] == 0) {
                orders[it] = order++
                queue.add(it)
            }
        }
    }
}
