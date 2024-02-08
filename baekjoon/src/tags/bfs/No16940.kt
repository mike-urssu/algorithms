package tags.bfs

/**
 * https://www.acmicpc.net/problem/16940
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableSet<Int>>

fun main() {
    val n = readln().toInt()
    graph = getGraph(n)
    val orders = readln().split(" ").map { it.toInt() }.toIntArray()
    if (areOrdersValid(n, orders)) {
        println(1)
    } else {
        println(0)
    }
}

private fun getGraph(n: Int): Array<MutableSet<Int>> {
    val graph = Array(n + 1) { mutableSetOf<Int>() }
    repeat(n - 1) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        graph[src].add(dst)
        graph[dst].add(src)
    }
    return graph
}

private fun areOrdersValid(n: Int, orders: IntArray): Boolean {
    val isVisited = BooleanArray(n + 1)
    isVisited[0] = true

    val queue = LinkedList<Int>() as Queue<Int>
    isVisited[1] = true
    queue.add(1)

    var indexToVisit = 1
    while (queue.isNotEmpty()) {
        val p = queue.poll()
        while (indexToVisit < n) {
            if (graph[p].isEmpty()) {
                break
            }

            val next = orders[indexToVisit]
            if (!graph[p].contains(next)) {
                return false
            }
            graph[p].remove(next)
            graph[next].remove(p)
            isVisited[next] = true
            queue.add(next)

            indexToVisit++
        }
    }
    return true
}
