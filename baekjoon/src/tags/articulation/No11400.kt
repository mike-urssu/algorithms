package tags.articulation

/**
 * https://www.acmicpc.net/problem/11400
 */
private lateinit var graph: Array<MutableList<Int>>
private var order = 1
private lateinit var orders: IntArray
private val articulations = sortedSetOf<Pair<Int, Int>>(Comparator { it, other ->
    var comparison = it.first.compareTo(other.first)
    if (comparison == 0) {
        comparison = it.second.compareTo(other.second)
    }
    comparison
})

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    graph = getGraph(v, e)
    orders = IntArray(v + 1)

    (1..v).forEach {
        if (orders[it] == 0) {
            dfs(0, it)
        }
    }

    println(articulations.size)
    articulations.forEach { (a, b) -> println("$a $b") }
}

private fun getGraph(v: Int, e: Int): Array<MutableList<Int>> {
    val graph = Array(v + 1) { mutableListOf<Int>() }
    repeat(e) {
        val (src, dst) = readln().split(" ").map { it.toInt() }
        graph[src].add(dst)
        graph[dst].add(src)
    }
    return graph
}

private fun dfs(parent: Int, node: Int): Int {
    orders[node] = order++
    var min = orders[node]

    graph[node].forEach { dst ->
        if (dst != parent) {
            if (orders[dst] == 0) {
                val low = dfs(node, dst)
                if (low > orders[node]) {
                    if (node < dst) {
                        articulations.add(node to dst)
                    } else {
                        articulations.add(dst to node)
                    }
                }
                min = min.coerceAtMost(low)
            } else {
                min = min.coerceAtMost(orders[dst])
            }
        }
    }

    return min
}
