package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1766
 */
import java.util.PriorityQueue
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = getGraph(n, m)
    val incomingNodes = getIncomingNodes(n, graph)
    println(getOrders(graph, incomingNodes).joinToString(" "))
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        graph[src].add(dst)
    }
    return graph
}

private fun getIncomingNodes(n: Int, graph: Array<MutableList<Int>>): IntArray {
    val incomingNodes = IntArray(n + 1)
    graph.forEach { row ->
        row.forEach { incomingNodes[it]++ }
    }
    return incomingNodes
}

private fun getOrders(graph: Array<MutableList<Int>>, incomingNodes: IntArray): List<Int> {
    val orders = mutableListOf<Int>()
    val queue = getQueue(incomingNodes)
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        orders.add(node)
        graph[node].forEach {
            incomingNodes[it]--
            if (incomingNodes[it] == 0) {
                queue.add(it)
            }
        }
    }
    return orders.drop(1)
}

private fun getQueue(incomingNodes: IntArray): Queue<Int> {
    val queue = PriorityQueue<Int>()
    incomingNodes.forEachIndexed { i, node ->
        if (node == 0) {
            queue.add(i)
        }
    }
    return queue
}
