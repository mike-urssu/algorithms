package tags.dfs

/**
 * https://www.acmicpc.net/problem/16964
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

private lateinit var graph: Array<MutableList<Int>>
private lateinit var orders: IntArray
private lateinit var isVisited: BooleanArray
private lateinit var visitedOrders: IntArray

fun main() {
    val n = reader.readLine().toInt()
    graph = getGraph(n)
    isVisited = BooleanArray(n + 1)
    orders = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    sortGraph(n)

    if (areOrdersValid(n)) {
        println(1)
    } else {
        println(0)
    }
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (src, dst) = reader.readLine().split(" ").map { it.toInt() }
        graph[src].add(dst)
        graph[dst].add(src)
    }
    return graph
}

private fun sortGraph(n: Int) {
    (1..n).forEach { i ->
        graph[i].sortWith { it, other -> orders.indexOf(it).compareTo(orders.indexOf(other)) }
    }
}

private var index = 0

private fun areOrdersValid(n: Int): Boolean {
    visitedOrders = IntArray(n)
    visitedOrders[index++] = 1
    isVisited[1] = true

    dfs(1)

    return orders.contentEquals(visitedOrders)
}

private fun dfs(src: Int) {
    graph[src].forEach { node ->
        if (!isVisited[node] && visitedOrders[index] == 0) {
            visitedOrders[index++] = node
            isVisited[node] = true
            dfs(node)
        }
    }
}
