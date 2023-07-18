package tags.sorting

/**
 * https://www.acmicpc.net/problem/24479
 */
import java.util.SortedSet

private lateinit var graph: Array<SortedSet<Int>>
private lateinit var visitedOrders: IntArray

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    graph = Array(n + 1) { sortedSetOf() }
    visitedOrders = IntArray(n + 1)
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    dfs(r)
    (1..n).forEach { i -> println(visitedOrders[i]) }
}

private var order = 1
private fun dfs(r: Int) {
    visitedOrders[r] = order++

    graph[r].forEach { num ->
        if (visitedOrders[num] == 0) {
            dfs(num)
        }
    }
}
