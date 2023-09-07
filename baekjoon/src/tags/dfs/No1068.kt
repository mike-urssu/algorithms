package tags.dfs

/**
 * https://www.acmicpc.net/problem/1068
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isRemoved: BooleanArray

fun main() {
    val n = readln().toInt()
    val parents = readln().split(" ").map { it.toInt() }.toIntArray()
    val m = readln().toInt()

    graph = Array(n) { mutableListOf() }
    parents.forEachIndexed { i, node ->
        if (node != -1) {
            graph[parents[i]].add(i)
        }
    }
    isRemoved = BooleanArray(n)

    removeNode(m)
    val count = (0 until n).count { i -> isLeafNode(i) }
    println(count)
}

private fun removeNode(m: Int) {
    graph[m].forEach { removeNode(it) }
    isRemoved[m] = true
}

private fun isLeafNode(node: Int): Boolean {
    if (isRemoved[node]) {
        return false
    }
    return graph[node].count { !isRemoved[it] } == 0
}
