package tags.bfs

/**
 * https://www.acmicpc.net/problem/1260
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<MutableList<Int>>
private lateinit var orders: MutableList<Int>
private lateinit var isVisited: BooleanArray

fun main() {
    val (n, m, v) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n, m)

    orders = mutableListOf()
    isVisited = BooleanArray(n + 1)
    dfs(v)
    println(orders.joinToString(" "))

    orders = mutableListOf()
    isVisited = BooleanArray(n + 1)
    bfs(v)
    println(orders.joinToString(" "))
}

private fun getGraph(n: Int, m: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        graph[src].add(dst)
        graph[dst].add(src)
    }
    graph.forEach { it.sort() }
    return graph
}

private fun dfs(src: Int) {
    isVisited[src] = true
    orders.add(src)

    graph[src].forEach { i ->
        if (!isVisited[i]) {
            dfs(i)
        }
    }
}

private fun bfs(src: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(src)
    isVisited[src] = true

    while (queue.isNotEmpty()) {
        val n = queue.poll()
        orders.add(n)
        graph[n].forEach { i ->
            if (!isVisited[i]) {
                queue.add(i)
                isVisited[i] = true
            }
        }
    }
}
