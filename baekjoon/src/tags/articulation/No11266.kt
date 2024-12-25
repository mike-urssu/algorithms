package tags.articulation

/**
 * https://www.acmicpc.net/problem/11266
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var orders: IntArray
private lateinit var isArticulation: BooleanArray
private var order = 1

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    graph = getGraph(v, e)
    orders = IntArray(v + 1)
    isArticulation = BooleanArray(v + 1)

    (1..v).forEach {
        if (orders[it] == 0) {
            dfs(it, true)
        }
    }

    val count = isArticulation.count { it }
    println(count)
    if (count != 0) {
        val indices = (1..v).filter { isArticulation[it] }
        println(indices.joinToString(" "))
    }
}

private fun getGraph(v: Int, e: Int): Array<MutableList<Int>> {
    val graph = Array(v + 1) { mutableListOf<Int>() }
    repeat(e) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    return graph
}

private fun dfs(v: Int, isRoot: Boolean): Int {
    orders[v] = order++
    var childNodes = 0

    var min = orders[v]
    graph[v].forEach { node ->
        if (orders[node] == 0) {
            childNodes++
            val low = dfs(node, false)
            if (!isRoot && low >= orders[v]) {
                isArticulation[v] = true
            }
            min = min.coerceAtMost(low)
        } else {
            min = min.coerceAtMost(orders[node])
        }
    }

    if (isRoot && childNodes >= 2) {
        isArticulation[v] = true
    }

    return min
}
