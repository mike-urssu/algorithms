package tags.topological_sorting

/**
 * https://www.acmicpc.net/problem/2252
 */
import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val connections = Array(n + 1) { mutableListOf<Int>() }
    val counts = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        connections[a].add(b)
        counts[b]++
    }

    val orders = getOrders(n, connections, counts)
    println(orders.joinToString(" "))
}

private fun getOrders(n: Int, connections: Array<MutableList<Int>>, counts: IntArray): List<Int> {
    val orders = mutableListOf<Int>()
    val queue = LinkedList<Int>() as Queue<Int>

    queue.addAll((1..n).filter { counts[it] == 0 })
    while (queue.isNotEmpty()) {
        val p = queue.poll()
        orders.add(p)
        connections[p].forEach { i ->
            counts[i]--
            if (counts[i] == 0) {
                queue.add(i)
            }
        }
    }

    return orders
}
