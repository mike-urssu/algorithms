package tags.trees

/**
 * https://www.acmicpc.net/problem/15681
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var parents: IntArray
private lateinit var children: Array<MutableList<Int>>
private lateinit var subtreeVertexes: IntArray

fun main() {
    val (n, r, q) = readln().split(" ").map { it.toInt() }
    graph = Array(n + 1) { mutableListOf() }
    parents = IntArray(n + 1)
    children = Array(n + 1) { mutableListOf() }
    subtreeVertexes = IntArray(n + 1)

    repeat(n - 1) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    makeTree(r, -1)
    countSubtreeNodes(r)

    repeat(q) {
        val u = readln().toInt()
        println(subtreeVertexes[u])
    }
}

private fun makeTree(currentNode: Int, parent: Int) {
    for (node in graph[currentNode]) {
        if (node != parent) {
            children[currentNode].add(node)
            parents[node] = currentNode
            makeTree(node, currentNode)
        }
    }
}

private fun countSubtreeNodes(currentNode: Int) {
    subtreeVertexes[currentNode] = 1
    for (node in children[currentNode]) {
        countSubtreeNodes(node)
        subtreeVertexes[currentNode] += subtreeVertexes[node]
    }
}
