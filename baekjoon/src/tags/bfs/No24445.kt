package tags.bfs

/**
 * https://www.acmicpc.net/problem/24445
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    val orders = getOrders(n, r)
    (1..n).forEach { println(orders[it]) }
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    graph.forEach { it.sortDescending() }
    return graph
}

private fun getOrders(n: Int, r: Int): IntArray {
    val orders = IntArray(n + 1)
    var order = 1

    val queue = LinkedList<Int>() as Queue<Int>
    queue.add(r)
    orders[r] = order++

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        graph[p].forEach {
            if (orders[it] == 0) {
                queue.add(it)
                orders[it] = order++
            }
        }
    }

    return orders
}
