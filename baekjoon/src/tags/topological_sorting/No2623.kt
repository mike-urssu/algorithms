package tags.topological_sorting

/**
 * https://www.acmicpc.net/problem/2623
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var counts: IntArray
private lateinit var graph: Array<MutableList<Int>>
private val orders = mutableListOf<Int>()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    counts = IntArray(n + 1)
    graph = Array(n + 1) { mutableListOf() }

    repeat(m) {
        val input = readln().split(" ").map { it.toInt() }
        val size = input[0]
        val orders = input.drop(1)
        (1 until size).forEach { i ->
            graph[orders[i - 1]].add(orders[i])
            counts[orders[i]]++
        }
    }

    val isValid = setOrders(n)
    if (isValid) {
        orders.forEach { println(it) }
    } else {
        println(0)
    }
}

private fun setOrders(n: Int): Boolean {
    val queue: Queue<Int> = LinkedList<Int>().apply {
        val startPoints = (1..n).filter { counts[it] == 0 }
        this.addAll(startPoints)
    }

    while (queue.isNotEmpty()) {
        val src = queue.poll()
        orders.add(src)
        graph[src].forEach { dst ->
            counts[dst]--
            if (counts[dst] == 0) {
                queue.add(dst)
            }
        }
    }

    return counts.all { it == 0 }
}
