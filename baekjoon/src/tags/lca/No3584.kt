package tags.lca

/**
 * https://www.acmicpc.net/problem/3584
 */
private lateinit var parents: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        parents = getParents(n)
        isVisited = BooleanArray(n + 1)

        val (node1, node2) = readln().split(" ").map { it.toInt() }
        println(lca(node1, node2))
    }
}

private fun getParents(n: Int): IntArray {
    val parents = IntArray(n + 1) { it }
    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        parents[b] = a
    }
    return parents
}

private fun lca(node1: Int, node2: Int): Int {
    visitAncestors(node1)

    var commonAncestor = node2
    while (!isVisited[commonAncestor]) {
        commonAncestor = parents[commonAncestor]
    }
    return commonAncestor
}

private fun visitAncestors(node: Int) {
    isVisited[node] = true
    if (parents[node] == node) {
        return
    }
    visitAncestors(parents[node])
}
