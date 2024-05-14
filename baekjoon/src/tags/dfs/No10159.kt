package tags.dfs

/**
 * https://www.acmicpc.net/problem/10159
 */
private var n = 0
private lateinit var graph1: Array<MutableList<Int>>
private lateinit var graph2: Array<MutableList<Int>>

private lateinit var counts1: IntArray
private lateinit var counts2: IntArray

private lateinit var isVisited: BooleanArray

fun main() {
    n = readln().toInt()
    graph1 = Array(n + 1) { mutableListOf() }
    graph2 = Array(n + 1) { mutableListOf() }
    counts2 = IntArray(n + 1)
    counts1 = IntArray(n + 1)

    val m = readln().toInt()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph1[a].add(b)
        graph2[b].add(a)
    }

    (1..n).forEach { i ->
        isVisited = BooleanArray(n + 1)
        dfs1(i, i)
    }
    (1..n).forEach { i ->
        isVisited = BooleanArray(n + 1)
        dfs2(i, i)
    }

    (1..n).forEach { i -> println(n - (counts1[i] + counts2[i]) + 1) }
}

private fun dfs1(src: Int, node: Int) {
    counts1[src]++
    isVisited[node] = true
    graph1[node].forEach {
        if (!isVisited[it]) {
            dfs1(src, it)
        }
    }
}

private fun dfs2(src: Int, node: Int) {
    counts2[src]++
    isVisited[node] = true
    graph2[node].forEach {
        if (!isVisited[it]) {
            dfs2(src, it)
        }
    }
}
