package tags.mst

/**
 * https://www.acmicpc.net/problem/1197
 */
private lateinit var graph: Array<Triple<Int, Int, Int>>
private lateinit var parents: IntArray

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    graph = getGraph(e)
    println(mst(v))
}

private fun getGraph(e: Int): Array<Triple<Int, Int, Int>> {
    val graph = Array(e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        Triple(a, b, c)
    }
    graph.sortWith { it, other -> it.third.compareTo(other.third) }
    return graph
}

private fun mst(v: Int): Int {
    parents = IntArray(v + 1) { it }

    var mst = 0
    graph.forEach { (a, b, c) ->
        if (find(a) != find(b)) {
            union(a, b)
            mst += c
        }
    }
    return mst
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    parents[parentA] = parentB
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
