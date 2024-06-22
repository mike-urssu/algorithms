package tags.scc

/**
 * https://www.acmicpc.net/problem/2150
 */
import java.util.Stack

private lateinit var graph: Array<MutableList<Int>>
private lateinit var parents: IntArray

private val stack = Stack<Int>()
private lateinit var isSCC: BooleanArray
private val set = sortedSetOf<List<Int>>(compareBy { it.min() })

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    graph = getGraph(v, e)
    parents = IntArray(v + 1)
    isSCC = BooleanArray(v + 1)

    (1..v).forEach { src ->
        if (!isSCC[src]) {
            dfs(src)
        }
    }

    println(set.size)
    set.forEach { println("${it.joinToString(" ")} -1") }
}

private fun getGraph(v: Int, e: Int): Array<MutableList<Int>> {
    val graph = Array(v + 1) { mutableListOf<Int>() }
    repeat(e) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
    }
    graph.forEach { it.sort() }
    return graph
}

private var id = 0

private fun dfs(src: Int): Int {
    parents[src] = ++id
    stack.push(src)

    var parent = parents[src]
    graph[src].forEach { dst ->
        if (parents[dst] == 0) {
            parent = parent.coerceAtMost(dfs(dst))
        } else if (!isSCC[dst]) {
            parent = parent.coerceAtMost(parents[dst])
        }
    }

    if (parent == parents[src]) {
        val scc = mutableListOf<Int>()
        while (true) {
            val p = stack.pop()
            isSCC[p] = true
            scc.add(p)
            if (p == src) {
                break
            }
        }
        set.add(scc.sorted())
    }
    return parent
}
